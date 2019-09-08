package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.driver.SmsDriver;
import com.spaco.streaminput.driver.WeChatAppletDriver;
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

    private void notifyNow()
    {

    }

    private void notifyQueue()
    {

    }

    private SmsDriver createSmsDriver()
    {
        return null;
    }

    private SmsDriver createMailDriver()
    {
        return null;
    }

    private WeChatAppletDriver createWeChatAppletDriver()
    {
        return null;
    }

}
