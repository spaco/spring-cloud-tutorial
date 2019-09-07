package com.spaco.streaminput.abstraction;


import org.springframework.stereotype.Service;

@Service
public class NotifyDispatcher {

    public void notify(AbstractNotification notification){
        for (AbstractNotification.ViaType viaType : notification.via()){

        }
    }
}
