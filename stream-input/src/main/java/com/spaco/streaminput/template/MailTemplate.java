package com.spaco.streaminput.template;

import com.spaco.streaminput.abstraction.base.BaseTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class MailTemplate extends BaseTemplate {
    @NotNull
    public String email;

    public String content;
}
