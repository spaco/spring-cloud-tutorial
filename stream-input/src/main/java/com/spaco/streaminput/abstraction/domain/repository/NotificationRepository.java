package com.spaco.streaminput.abstraction.domain.repository;

import com.spaco.streaminput.abstraction.domain.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
