package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.AbstractNotification;
import com.spaco.streaminput.message.RefuelMessage;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;

import java.util.Arrays;
import java.util.List;

public class RefuelNotification extends AbstractNotification {

    private RefuelMessage message;

    public RefuelNotification(RefuelMessage refuelMessage) {
        this.message = refuelMessage;
    }

    @Override
    public List<Type> via() {
        return Arrays.asList(Type.mail, Type.sms, Type.weChatApplet);
    }

    @Override
    public SmsTemplate toSms() {
        SmsTemplate template = new SmsTemplate();
        template.setPhone(message.getPhone());
        template.setContent("申请通过");
        return template;
    }

    @Override
    public WeChatAppletTemplate toWeChatApplet() {
        WeChatAppletTemplate template = new WeChatAppletTemplate();
        template.setContent("{}");
        template.setFormId("formId mock");
        template.setOpenId("openId mock");
        template.setPage("/page/index?tenantId=123");
        template.setTemplateId("config TemplateId");

        return template;
    }
}
