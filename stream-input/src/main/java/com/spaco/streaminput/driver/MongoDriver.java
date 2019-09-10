package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.abstraction.domain.repository.NotificationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MongoDriver implements Drivereable {
    private NotificationRepository notificationRepository;

    @Autowired
    public MongoDriver(NotificationRepository notificationRepository)
    {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void send(BaseNotification notification) {
        notificationRepository.saveAll(notification.toMongo());
    }
}
