package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.template.SmsTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SmsDriver  implements Drivereable {
    @Override
    public void send(BaseNotification notification) {
        for (SmsTemplate template:notification.toSms()) {
            //调用 open-api 还是 另外写一个发送短信的service
            log.error("SmsTemplate: {}", template.toString());
        }
    }
}
