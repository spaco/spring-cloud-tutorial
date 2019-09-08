package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.driver.ConstructionWeChatAppletDriver;
import com.spaco.streaminput.driver.MailDriver;
import com.spaco.streaminput.driver.SmsDriver;
import com.spaco.streaminput.driver.ProviderWeChatAppletDriver;
import org.springframework.beans.factory.annotation.Autowired;
import com.spaco.streaminput.abstraction.BaseNotification.ViaType;
import org.springframework.stereotype.Service;


@Service
public class DriverManager {
    private SmsDriver smsDriver;

    private MailDriver mailDriver;

    private ProviderWeChatAppletDriver providerWeChatAppletDriver;

    private ConstructionWeChatAppletDriver constructionWeChatAppletDriver;

    @Autowired
    public DriverManager(SmsDriver smsDriver,
                         MailDriver mailDriver,
                         ProviderWeChatAppletDriver providerWeChatAppletDriver,
                         ConstructionWeChatAppletDriver constructionWeChatAppletDriver) {
        this.smsDriver = smsDriver;
        this.mailDriver = mailDriver;
        this.providerWeChatAppletDriver = providerWeChatAppletDriver;
        this.constructionWeChatAppletDriver = constructionWeChatAppletDriver;
    }

    public Drivereable driver(ViaType viaType) {
        try {
            return (Drivereable) this.getClass().getMethod("create" + viaType.getType() + "Driver").invoke(this);
        } catch (Exception exception) {
            throw null;
        }
//        if (Objects.nonNull(method)) {
//            return (Drivereable) method.invoke(this);
//        }
    }

    private SmsDriver createSmsDriver() {
        return this.smsDriver;
    }

    private MailDriver createMailDriver() {
        return this.mailDriver;
    }

    private ProviderWeChatAppletDriver createProviderWeChatAppletDriver() {
        return this.providerWeChatAppletDriver;
    }

    private ConstructionWeChatAppletDriver createConstructionWeChatAppletDriver() {
        return this.constructionWeChatAppletDriver;
    }

}
