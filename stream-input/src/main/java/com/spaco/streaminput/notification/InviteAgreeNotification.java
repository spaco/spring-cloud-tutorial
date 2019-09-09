package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.base.BaseNotification;
import com.spaco.streaminput.message.InviteAgreeMessage;

import java.util.Arrays;
import java.util.List;

public class InviteAgreeNotification extends BaseNotification {

    private InviteAgreeMessage message;

    public InviteAgreeNotification(InviteAgreeMessage inviteAgreeMessage) {
        this.message = inviteAgreeMessage;
    }

    @Override
    public List<ViaType> via() {
        return Arrays.asList(ViaType.sms, ViaType.providerWeChatApplet);
    }


}
