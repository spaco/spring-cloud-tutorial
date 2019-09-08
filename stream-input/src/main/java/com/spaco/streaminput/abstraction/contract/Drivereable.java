package com.spaco.streaminput.abstraction.contract;

import com.spaco.streaminput.abstraction.BaseNotification;

public interface Drivereable {
    public void send(BaseNotification notification);
}
