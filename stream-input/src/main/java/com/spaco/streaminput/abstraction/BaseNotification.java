package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.template.MailTemplate;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BaseNotification {

    public enum ViaType{
        mail("mail"),
        sms("sms"),
        database("database"),
        weChatApplet("weChatApplet");

        private final String type;

        ViaType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    protected List<ViaType> via(){
        return null;
    }

    public MailTemplate toMail() {
        return null;
    }

    public void toDatabase() {
    }

    public List<SmsTemplate> toSms() {
        return null;
    }

    public WeChatAppletTemplate toWeChatApplet() {
        return null;
    }
}
