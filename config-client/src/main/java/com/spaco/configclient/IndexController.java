package com.spaco.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @Value("${filename}")
    private String filename;

    private final Environment environment;

    public IndexController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/filename")
    public String filename(){
        return "filename is :"+filename;
    }
    @GetMapping("/filename-env")
    public String filename_env(){
        return environment.getProperty("filename","undefine");
    }
}
