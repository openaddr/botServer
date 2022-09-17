package cn.yn.sever.botserver.handler;

import cn.yn.sever.botComon.annotation.GroupMsgHandler;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 群消息处理器
 * 可以在这里编写处理群消息的方法
 * 在收到群组消息后
 * 所有被@GroupMsgHandler标记的方法都会执行
 */
@Component
public class GroupMessageHandler {

    @GroupMsgHandler
    public void hello(GroupMessageEvent event) {
        Group group = event.getGroup();
        group.sendMessage("This is " + group);
    }
}
