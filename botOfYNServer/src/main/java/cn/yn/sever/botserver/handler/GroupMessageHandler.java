package cn.yn.sever.botserver.handler;

import cn.yn.sever.botserver.annotation.GroupMsgHandler;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 群消息处理器
 */
@Component
public class GroupMessageHandler {


    @GroupMsgHandler
    public void hello(GroupMessageEvent event) {
        Group group = event.getGroup();
        group.sendMessage("This is " + group);
    }
}
