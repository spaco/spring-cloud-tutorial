package com.spaco.streaminput.message;

import com.spaco.streaminput.abstraction.contract.Messageable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RefuelMessage implements Messageable {
    @NotNull
    public String phone;

    public String email;

    @NotNull
    public String openId;

    @NotNull
    public String weChatAppletPage;

    @NotNull
    public String weChatAppletContent;
}
