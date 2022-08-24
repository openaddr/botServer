package cn.yn.sever.botserver.listener;

import cn.hutool.core.convert.Convert;
import cn.yn.sever.botserver.handler.FriendMessageHandler;
import cn.yn.sever.botserver.handler.GroupMessageHandler;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
@Component
@ConditionalOnBean(FriendMessageHandler.class)
public class BotListener {

    @Autowired
    FriendMessageHandler friendMessageHandler;
    @Autowired
    GroupMessageHandler groupMessageHandler;

    /**
     * 监听所有事件,根据事件类型交给不同的handler处理
     * @param event
     */
    public void messageListener(Event event) {
        if (event.getClass() == FriendMessageEvent.class) { //如果是好友消息事件,交给好友消息处理器
            friendMessageHandler.hello(Convert.convert(FriendMessageEvent.class, event));
        } else if (event.getClass() == GroupMessageEvent.class){    //如果是群消息事件,交给群消息处理器
            groupMessageHandler.hello(Convert.convert(GroupMessageEvent.class,event));
        }
    }



}
