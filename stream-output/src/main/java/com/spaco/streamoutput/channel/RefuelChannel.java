package com.spaco.streamoutput.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RefuelChannel {
    String OUTPUT = "refuel";

    @Output(OUTPUT)
    MessageChannel output();
}
