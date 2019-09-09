package com.spaco.streaminput.abstraction;

import com.spaco.streaminput.abstraction.BaseNotification.ViaType;
import com.spaco.streaminput.abstraction.contract.Drivereable;
import com.spaco.streaminput.abstraction.util.StringUtil;
import com.spaco.streaminput.driver.ConstructionWeChatAppletDriver;
import com.spaco.streaminput.driver.MailDriver;
import com.spaco.streaminput.driver.ProviderWeChatAppletDriver;
import com.spaco.streaminput.driver.SmsDriver;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
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

    Drivereable driver(ViaType viaType) {
        log.info("create" + StringUtil.toInitialsUpperCase(viaType.getType()) + "Driver");
        try {
            return (Drivereable) this.getClass().getMethod("create" + StringUtil.toInitialsUpperCase(viaType.getType()) + "Driver").invoke(this);
        } catch (Exception exception) {
            throw new RuntimeException("createMessageDriver failed");
        }
    }

    // must be public
    public SmsDriver createSmsDriver() {
        return this.smsDriver;
    }

    public MailDriver createMailDriver() {
        return this.mailDriver;
    }

    public ProviderWeChatAppletDriver createProviderWeChatAppletDriver() {
        return this.providerWeChatAppletDriver;
    }

    public ConstructionWeChatAppletDriver createConstructionWeChatAppletDriver() {
        return this.constructionWeChatAppletDriver;
    }

}
