package com.spaco.streaminput.abstraction;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import com.spaco.streaminput.abstraction.BaseNotification.ViaType;

import java.lang.reflect.InvocationTargetException;

@Component
@Log4j2
public class NotifyDispatcher {
    private DriverManager driverManager;

    public NotifyDispatcher(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    protected void notify(BaseNotification notification) {
        log.error("this is notify");
        //notifyDelay or notifyNow
        this.notifyNow(notification);

    }

    private void notifyNow(BaseNotification notification)
    {
        for (ViaType viaType : notification.via()) {
            this.driverManager.driver(viaType).send(notification);
        }
    }

    private void notifyDelay(BaseNotification notification){

    }

}
