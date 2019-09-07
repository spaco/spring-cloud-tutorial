package com.spaco.streamoutput.controller;

import com.spaco.streamoutput.producer.RefuelService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RefuelController {

    private RefuelService refuelService;

    public RefuelController(RefuelService refuelService){
        this.refuelService = refuelService;
    }

    @GetMapping("/refuel")
    public String send(@RequestBody Object message)
    {
        log.error("sent message: {}",message);
        this.refuelService.send(message);

        return message.toString();
    }
}
