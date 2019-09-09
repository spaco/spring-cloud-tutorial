package com.spaco.streaminput.abstraction.base;

import com.spaco.streaminput.abstraction.NotifyDispatcher;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class BaseConsumer {

    @Autowired
    public NotifyDispatcher notifyDispatcher;

//    @Autowired
//    public BaseConsumer(NotifyDispatcher notifyDispatcher){
//        this.notifyDispatcher = notifyDispatcher;
//    }

//    public void receive(Messageable messageable){
//
//    }

    protected void notify(BaseNotification notification){
        this.notifyDispatcher.notify(notification);
    }
}
