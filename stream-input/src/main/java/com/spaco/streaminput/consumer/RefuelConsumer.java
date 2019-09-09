package com.spaco.streaminput.consumer;

import com.spaco.streaminput.abstraction.base.BaseConsumer;
import com.spaco.streaminput.channel.RefuelChannel;
import com.spaco.streaminput.message.RefuelMessage;
import com.spaco.streaminput.notification.RefuelNotification;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(RefuelChannel.class)
@Log4j2
public class RefuelConsumer extends BaseConsumer {

    @StreamListener(RefuelChannel.INPUT)
    public void receive(RefuelMessage payload) {
        //openId 由那个服务获取？saas or notification
        log.error("received message: {}",payload);

//        RefuelMessage message = new RefuelMessage();

        notify(new RefuelNotification(payload));
    }


}