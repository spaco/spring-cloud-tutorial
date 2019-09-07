package com.spaco.streaminput.message;

import com.spaco.streaminput.abstraction.contract.Messageable;
import lombok.Data;

@Data
public class RefuelMessage implements Messageable {
    public String phone;

    public String email;
}
