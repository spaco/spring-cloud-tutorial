package com.spaco.streaminput.abstraction.notification;

import lombok.Data;

@Data
public abstract class AbstractConsumer {

//    public AbstractNotification(){
//
//    }

//    public void receive(Object payload){
//
//    }

    protected void notify(AbstractNotification notification){

    }

}
