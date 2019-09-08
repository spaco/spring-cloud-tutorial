package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.BaseNotification;
import com.spaco.streaminput.message.InviteAgreeMessage;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;

import java.util.Arrays;
import java.util.List;

public class InviteAgreeNotification extends BaseNotification {

    private InviteAgreeMessage inviteAgreeMessage;

    public InviteAgreeNotification(InviteAgreeMessage inviteAgreeMessage) {
        this.inviteAgreeMessage = inviteAgreeMessage;
    }

    @Override
    public List<ViaType> via() {
        return Arrays.asList(ViaType.sms, ViaType.weChatApplet);
    }

    @Override
    public SmsTemplate toSms() {
        SmsTemplate template = new SmsTemplate();
        template.setPhone(inviteAgreeMessage.getPhone());
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
