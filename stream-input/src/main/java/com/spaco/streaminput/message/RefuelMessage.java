package com.spaco.streaminput.message;

import com.spaco.streaminput.abstraction.contract.Messageable;
import lombok.Data;
import com.spaco.streaminput.abstraction.domain.document.Notification.Source;
import com.spaco.streaminput.abstraction.domain.document.Notification.Type;
import com.spaco.streaminput.abstraction.domain.document.Notification.SourceType;
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

    @NotNull
    private Type type;

    @NotNull
    private SourceType sourceType;

    public String phone;

    public String email;

    @NotNull
    public String openId;

    @NotNull
    public String weChatAppletPage;

    @NotNull
    public String weChatAppletContent;


}
