package com.spaco.streaminput.service;

import com.spaco.streaminput.channel.RefuelChannel;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(RefuelChannel.class)
@Log4j2
public class RefuelService {

    @StreamListener(RefuelChannel.INPUT)
    public void receive(Object payload){
        log.info("received message: {}",payload);
        System.out.println(payload);
    }
}