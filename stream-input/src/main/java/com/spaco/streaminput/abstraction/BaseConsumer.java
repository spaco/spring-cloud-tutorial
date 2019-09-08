package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.driver.ConstructionWeChatAppletDriver;
import com.spaco.streaminput.driver.SmsDriver;
import com.spaco.streaminput.driver.ProviderWeChatAppletDriver;
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
