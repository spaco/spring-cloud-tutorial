package com.spaco.streaminput.template;

import com.spaco.streaminput.abstraction.BaseTemplate;
import lombok.Data;

@Data
public class SmsTemplate extends BaseTemplate {
    public String phone;

    public String content;
}
