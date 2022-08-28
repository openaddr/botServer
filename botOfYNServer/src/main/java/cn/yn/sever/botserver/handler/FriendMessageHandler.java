package cn.yn.sever.botserver.handler;

import cn.yn.sever.botserver.annotation.FriendMsgHandler;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 好友消息处理器
 */
@Component
public class FriendMessageHandler {

    @FriendMsgHandler

    public void hello(FriendMessageEvent event) {
        Friend sender = event.getSender();
        sender.sendMessage("You are " + sender);
    }
    @FriendMsgHandler
    public void hello1(FriendMessageEvent event) {
        System.out.println("You are test friendMsg");
    }

    @FriendMsgHandler
    public void world(FriendMessageEvent event){
        System.out.println("world!!!");
    }

}
