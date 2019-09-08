package com.spaco.streaminput.template;

import com.spaco.streaminput.abstraction.BaseTemplate;
import lombok.Data;

@Data
public class MailTemplate extends BaseTemplate {
    public String email;

    public String content;
}
