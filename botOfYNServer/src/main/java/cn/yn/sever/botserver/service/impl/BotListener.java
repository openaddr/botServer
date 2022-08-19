package cn.yn.sever.botserver.service.impl;

import cn.hutool.core.convert.Convert;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
public class BotListener {
    public static void messageListener(Event event) {
        if (event.getClass() == FriendMessageEvent.class){
            FriendMessageEvent friendMessageEvent = Convert.convert(FriendMessageEvent.class, event);
            Friend sender = friendMessageEvent.getSender();
            sender.sendMessage("You are "+ sender);
        }
    }

}
