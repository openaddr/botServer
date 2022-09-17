package cn.yn.sever.botserver.handler;

import cn.yn.sever.botComon.annotation.FriendMsgHandler;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 好友消息处理器
 * 可以在这里编写好友消息的处理方法
 * 在收到好友消息后,被@FriendMsgHandler标记的方法会自动执行
 *
 * @FriendMsgHandler可以接受参数,类型为long
 * 如果没有传参,则默认执行
 * 如果传递了参数,则只有当好友消息来源QQ=所传long值时,才会执行
 */
@Component
public class FriendMessageHandler {
    @FriendMsgHandler
    public void hello(FriendMessageEvent event) {
        Friend sender = event.getSender();
        sender.sendMessage("You are " + sender);
    }

}
