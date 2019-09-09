package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.BaseNotification;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProviderWeChatAppletDriver implements Drivereable {
    @Override
    public void send(BaseNotification notification) {
        for (WeChatAppletTemplate template:notification.toProviderWeChatApplet()){
            log.error("WeChatAppletTemplate: {}", template.toString());
        }
    }
}
