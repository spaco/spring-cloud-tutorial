package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.template.MailTemplate;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BaseNotification {

    public enum ViaType {
        mail("mail"),
        sms("sms"),
        database("database"),
        providerWeChatApplet("providerWeChatApplet"),
        constructionWeChatApplet("constructionWeChatApplet");

        private final String type;

        ViaType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    protected List<ViaType> via() {
        return null;
    }

    // send to many people
    public List<MailTemplate> toMail() {
        return null;
    }

    public List<SmsTemplate> toDatabase() {
        return null;
    }

    public List<SmsTemplate> toSms() {
        return null;
    }

    public List<WeChatAppletTemplate> toProviderWeChatApplet() {
        return null;
    }

    public List<WeChatAppletTemplate> toConstructionWeChatApplet() {
        return null;
    }
}
