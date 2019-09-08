package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.BaseNotification;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProviderWeChatAppletDriver implements Drivereable {
    @Override
    public void send(BaseNotification notification) {
        for (WeChatAppletTemplate template:notification.toProviderWeChatApplet()){
            
        }
    }
}
