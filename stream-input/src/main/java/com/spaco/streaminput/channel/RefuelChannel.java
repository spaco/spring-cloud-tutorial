package com.spaco.streaminput.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RefuelChannel {
    String INPUT = "refuel";

    @Input(INPUT)
    MessageChannel input();
}
