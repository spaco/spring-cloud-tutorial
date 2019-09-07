package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.abstraction.contract.Messageable;
import lombok.Data;

@Data
public abstract class AbstractConsumer {

//    public AbstractNotification(){
//
//    }

//    public void receive(Messageable messageable){
//
//    }

    protected void notify(AbstractNotification notification){

    }

}
