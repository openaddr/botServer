package cn.yn.sever.botserver.service.impl;

import cn.hutool.core.convert.Convert;
import cn.yn.sever.botserver.handler.BotHandler;
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
@ConditionalOnBean(BotHandler.class)
public class BotListener {

    public  void messageListener(Event event) {
        this.extracted(event);
    }

    private  void extracted(Event event) {
        if (event.getClass() == FriendMessageEvent.class) {
            FriendMessageEvent friendMessageEvent = Convert.convert(FriendMessageEvent.class, event);
            Friend sender = friendMessageEvent.getSender();
            sender.sendMessage("You are " + sender);
        }
    }

}
