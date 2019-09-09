package com.spaco.streaminput.abstraction.base;

import com.spaco.streaminput.abstraction.domain.document.Notification;
import com.spaco.streaminput.template.MailTemplate;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;
import lombok.Data;

import java.util.List;

@Data
public abstract class BaseNotification {

    public enum ViaType {
        mail("mail"),
        sms("sms"),
        database("database"),
        providerWeChatApplet("providerWeChatApplet"),
        constructionWeChatApplet("constructionWeChatApplet"),
        mongo("mongo");

        private final String type;

        ViaType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public abstract List<ViaType> via();

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

    public List<Notification> toMongo() {
        return null;
    }
}
