package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.abstraction.domain.document.Notification;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MongoDriver implements Drivereable {
    @Override
    public void send(BaseNotification notification) {
        for (Notification template:notification.toMongo()) {
            log.error("SmsTemplate: {}", template.toString());
        }
    }
}
