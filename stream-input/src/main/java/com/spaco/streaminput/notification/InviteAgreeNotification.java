package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.notification.AbstractNotification;
import com.spaco.streaminput.message.InviteAgreeMessage;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;

import java.util.Arrays;
import java.util.List;

public class InviteAgreeNotification extends AbstractNotification {

    private InviteAgreeMessage inviteAgreeMessage;

    public InviteAgreeNotification(InviteAgreeMessage inviteAgreeMessage)
    {
        this.inviteAgreeMessage = inviteAgreeMessage;
    }

    public List<Type> via() {
        return Arrays.asList(Type.sms, Type.weChatApplet);
    }

    public SmsTemplate toSms()
    {
        SmsTemplate template = new SmsTemplate();
        template.setPhone(inviteAgreeMessage.getPhone());
        template.setContent("申请通过");
        return template;
    }

    public WeChatAppletTemplate toWeChatApplet()
    {
        WeChatAppletTemplate template = new WeChatAppletTemplate();
        template.setContent("{}");
        template.setFormId("formId mock");
        template.setOpenId("openId mock");
        template.setPage("/page/index?tenantId=123");
        template.setTemplateId("config TemplateId");

        return template;
    }
}
