package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractNotification {

    public enum Type{
        mail("mail"),
        sms("sms"),
        database("database"),
        weChatApplet("weChatApplet");

        private final String type;

        Type(String type) {
            this.type = type;
        }
    }

    protected List<Type> via(){
        return null;
    }

    protected void toMail() {
    }

    protected void toDatabase() {
    }

    protected SmsTemplate toSms() {
        return null;
    }

    protected WeChatAppletTemplate toWeChatApplet() {
        return null;
    }
}
