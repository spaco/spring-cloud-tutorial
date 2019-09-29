package com.spaco.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;

@SpringBootApplication
@RefreshScope
public class ConfigClientApplication {

    private static String filename;

    @Value("${filename}")
    public void fileName(String name) {
        filename = name;
    }

    private static Environment environment;

    public ConfigClientApplication(Environment environment) {
        ConfigClientApplication.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);

        System.out.println("filename is " + filename);
        System.out.println("env-filename is " + environment.getProperty("filename","undefine"));
    }

}
