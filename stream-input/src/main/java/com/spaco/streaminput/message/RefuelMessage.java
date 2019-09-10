package com.spaco.streaminput.message;

import com.spaco.streaminput.abstraction.contract.Messageable;
import com.spaco.streaminput.abstraction.domain.document.Notification;
import lombok.Data;
import com.spaco.streaminput.abstraction.domain.document.Notification.Source;

import javax.validation.constraints.NotNull;

@Data
public class RefuelMessage implements Messageable {
    @NotNull
    public String title;

    @NotNull
    public String content;

    @NotNull
    public Long sourceId;

    @NotNull
    public Long userId;

    public Source source;


    public String phone;

    public String email;

    @NotNull
    public String openId;

    @NotNull
    public String weChatAppletPage;

    @NotNull
    public String weChatAppletContent;


}
