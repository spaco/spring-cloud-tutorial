package com.spaco.streamoutput.service;

import com.spaco.streamoutput.channel.RefuelChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

//@EnableBinding(Source.class)
@EnableBinding(RefuelChannel.class)
public class RefuelService {

    private RefuelChannel refuelChannel;
    public RefuelService(RefuelChannel refuelChannel)
    {
        this.refuelChannel = refuelChannel;
    }

    public void send(String message)
    {
        refuelChannel.output().send(MessageBuilder.withPayload(message).build());
    }
}
