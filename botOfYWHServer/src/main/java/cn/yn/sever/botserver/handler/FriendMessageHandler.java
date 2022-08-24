package cn.yn.sever.botserver.handler;

import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 好友消息处理器
 * 可以在这里编写好友消息的处理方法
 */
@Component
public class FriendMessageHandler {
    public void hello(FriendMessageEvent event) {
        Friend sender = event.getSender();
        sender.sendMessage("You are " + sender);
    }

}
