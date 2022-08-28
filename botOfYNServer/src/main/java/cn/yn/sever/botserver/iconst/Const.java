package cn.yn.sever.botserver.iconst;

import cn.yn.sever.botserver.annotation.FriendMsgHandler;
import cn.yn.sever.botserver.annotation.GroupMsgHandler;
import lombok.Data;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.lang.annotation.Annotation;

public class Const {


    public enum EventHandler {

        FriendMsgEvent(FriendMessageEvent.class, FriendMsgHandler.class),
        GroupMsgEvent(GroupMessageEvent.class, GroupMsgHandler.class);

        private Class<? extends Event> event;
        private Class<? extends Annotation> annotation;

        EventHandler(Class<? extends Event> friendMessageEventClass, Class<? extends Annotation> friendMsgHandlerClass) {

        }

        public Class<? extends Event> getEvent() {
            return event;
        }

        public Class<? extends Annotation> getAnnotation() {
            return annotation;
        }
    }
}