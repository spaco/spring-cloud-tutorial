package com.spaco.streaminput.template;

import lombok.Data;

@Data
public class WeChatAppletTemplate {
    public String openId;

    public String templateId;

    public String formId;

    public String page;

    public String content;
}
