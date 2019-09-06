package com.spaco.streaminput.notification;

import com.spaco.streaminput.abstraction.notification.AbstractNotification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefuelNotification extends AbstractNotification {

//    private final static List<String>  VIA = Arrays.asList("mail", "sms");

    public List<Type> via() {
        return Arrays.asList(Type.mail, Type.sms, Type.weChatApplet);
    }

    public void toMail()
    {

    }
}
