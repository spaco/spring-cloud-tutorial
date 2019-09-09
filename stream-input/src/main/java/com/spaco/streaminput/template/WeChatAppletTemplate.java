package com.spaco.streaminput.template;

import com.spaco.streaminput.abstraction.base.BaseTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeChatAppletTemplate extends BaseTemplate {
    @NotNull
    public String openId;

    @NotNull
    public String templateId;

    @NotNull
    public String formId;

    public String page;

    public String content;
}
