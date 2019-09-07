package com.spaco.streamoutput.controller;

import com.spaco.streamoutput.producer.RefuelProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RefuelController {

    private RefuelProducer refuelProducer;

    public RefuelController(RefuelProducer refuelProducer){
        this.refuelProducer = refuelProducer;
    }

    @GetMapping("/refuel")
    public String send(@RequestBody Object message)
    {
        log.error("sent message: {}",message);
        this.refuelProducer.send(message);

        return message.toString();
    }
}
