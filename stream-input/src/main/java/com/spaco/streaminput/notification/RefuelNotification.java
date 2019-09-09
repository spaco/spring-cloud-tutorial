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
        return Arrays.asList(ViaType.sms, ViaType.providerWeChatApplet);
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
        template.setSourceId(1112L);
        template.setTitle("机械进场通知");
        template.setUserId(111L);
        template.setContent("{\"image_cover_url\":null,\"machine_name\":\"\\u5409\\u666e\\u8f66-\\u6e58AV002\",\"category_name\":\"\\u5176\\u4ed6\\u7c7b\\u578b\",\"brand_name\":\"\\u5176\\u4ed6\\u54c1\\u724c\",\"model_name\":\"\\u5176\\u4ed6\\u578b\\u53f7\",\"project_name\":\"\\u9879\\u76ee\\u6d4b\\u8bd501\"}");
        list.add(template);

        return list;
    }
}
