package com.spaco.streaminput.abstraction;


import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.abstraction.base.BaseNotification.ViaType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class NotifyDispatcher {
    private DriverManager driverManager;

    @Autowired
    public NotifyDispatcher(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void notify(BaseNotification notification) {
        log.error("this is notify");
        //notifyDelay or notifyNow
        this.notifyNow(notification);
    }

    private void notifyNow(BaseNotification notification) {
        log.info("notifyNow viaTypes : {}", notification.via().toString());
        for (ViaType viaType : notification.via()) {
            log.info("notifyNow viaType : {}", viaType);
            this.driverManager.driver(viaType).send(notification);
        }
    }

    private void notifyDelay(BaseNotification notification) {

    }

}
