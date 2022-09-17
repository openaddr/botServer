package cn.yn.sever.botserver.handler;

import cn.yn.sever.botComon.annotation.FriendMsgHandler;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 好友消息处理器
 */
@Component
public class FriendMessageHandler {

    @FriendMsgHandler(2413823382L)
    public void hello(FriendMessageEvent event) {
        event.getFriend().sendMessage("you are " + event.getFriend().getId());
    }

    @FriendMsgHandler(2357902824L)
    public void hello1(FriendMessageEvent event) {
        System.out.println("You are test friendMsg");
    }

    @FriendMsgHandler
    public void world(FriendMessageEvent event) {
        System.out.println("world!!!");
    }

}
