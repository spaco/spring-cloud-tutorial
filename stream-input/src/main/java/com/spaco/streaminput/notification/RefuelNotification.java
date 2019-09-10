package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.abstraction.domain.document.Notification;
import com.spaco.streaminput.message.RefuelMessage;
import com.spaco.streaminput.template.SmsTemplate;
import com.spaco.streaminput.template.WeChatAppletTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefuelNotification extends BaseNotification {

    private RefuelMessage message;

    public RefuelNotification(RefuelMessage refuelMessage) {
        this.message = refuelMessage;
    }

    @Override
    public List<ViaType> via() {
        return Arrays.asList(ViaType.sms, ViaType.providerWeChatApplet, ViaType.mongo);
    }

    @Override
    public List<SmsTemplate> toSms() {
        List<SmsTemplate> list = new ArrayList<>();
        SmsTemplate template = new SmsTemplate();
        template.setPhone(message.getPhone());
        template.setContent("申请通过");
        list.add(template);

        return list;
    }

    @Override
    public List<WeChatAppletTemplate> toProviderWeChatApplet() {
        List<WeChatAppletTemplate> list = new ArrayList<>();

        WeChatAppletTemplate template = new WeChatAppletTemplate();
        template.setContent(message.getWeChatAppletContent());
        template.setFormId("formId mock");
        template.setOpenId(message.getOpenId());
        template.setPage(message.getWeChatAppletPage());
        template.setTemplateId("config TemplateId");
        list.add(template);

        return list;
    }

    @Override
    public List<WeChatAppletTemplate> toConstructionWeChatApplet() {
        List<WeChatAppletTemplate> list = new ArrayList<>();

        WeChatAppletTemplate template = new WeChatAppletTemplate();
        template.setContent("{}");
        template.setFormId("formId mock2");
        template.setOpenId("openId mock2");
        template.setPage("/page/index?tenantId=1234");
        template.setTemplateId("config TemplateId2");
        list.add(template);

        return list;
    }


    @Override
    public List<Notification> toMongo() {
        List<Notification> list = new ArrayList<>();

        Notification template = new Notification();
        template.setSourceId(message.getSourceId());
        template.setTitle(message.getTitle());
        template.setUserId(message.getUserId());
        template.setContent(message.getContent());
        template.setSource(message.source);
        template.setType(message.getType());
        template.setSourceType(message.getSourceType());
        list.add(template);

        return list;
    }
}
