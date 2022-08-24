package cn.yn.sever.botserver.handler;

import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.stereotype.Component;

/**
 * 群消息处理器
 */
@Component
public class GroupMessageHandler {

    public void hello(GroupMessageEvent event) {
        Group group = event.getGroup();
        group.sendMessage("This is " + group);
    }
}
