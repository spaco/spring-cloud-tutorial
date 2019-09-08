package com.spaco.streaminput.driver;

import com.spaco.streaminput.abstraction.BaseNotification;
import com.spaco.streaminput.abstraction.BaseTemplate;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import org.springframework.stereotype.Component;

@Component
public class SmsDriver  implements Drivereable {
    @Override
    public void send(BaseNotification notification) {
    }
}
