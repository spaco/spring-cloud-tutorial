package com.spaco.streamoutput.producer;

import com.spaco.streamoutput.channel.RefuelChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

//@EnableBinding(Source.class)
@EnableBinding(RefuelChannel.class)
public class RefuelProducer {

    private RefuelChannel refuelChannel;
    public RefuelProducer(RefuelChannel refuelChannel)
    {
        this.refuelChannel = refuelChannel;
    }

    public void send(String message)
    {
        refuelChannel.output().send(MessageBuilder.withPayload(message).build());
    }

    public void send(Object message)
    {
        refuelChannel.output().send(MessageBuilder.withPayload(message).build());
    }
}
