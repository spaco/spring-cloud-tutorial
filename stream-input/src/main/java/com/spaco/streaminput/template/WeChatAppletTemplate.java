package com.spaco.streaminput.template;

import com.spaco.streaminput.abstraction.BaseTemplate;
import lombok.Data;

@Data
public class WeChatAppletTemplate extends BaseTemplate {
    public String openId;

    public String templateId;

    public String formId;

    public String page;

    public String content;
}
