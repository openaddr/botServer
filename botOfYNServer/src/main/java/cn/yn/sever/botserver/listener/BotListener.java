package cn.yn.sever.botserver.listener;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ClassUtil;
import cn.yn.sever.botserver.BotOfYNApplication;
import cn.yn.sever.botserver.annotation.FriendMsgHandler;
import cn.yn.sever.botserver.annotation.GroupMsgHandler;
import cn.yn.sever.botserver.handler.FriendMessageHandler;
import cn.yn.sever.botserver.handler.GroupMessageHandler;
import cn.yn.sever.botserver.iconst.Const;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
//@ConditionalOnBean(FriendMessageHandler.class)
public class BotListener {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    FriendMessageHandler friendMessageHandler;
    @Autowired
    GroupMessageHandler groupMessageHandler;



    /**
     * 监听所有事件,根据事件类型交给不同的handler处理
     *  todo 重复量太高!!!
     * @param event
     */
    public void messageListener(Event event) {
//        if (event.getClass() == Const.EventHandler.FriendMsgEvent.getEvent()) { //如果是好友消息事件,交给好友消息处理器
//            List<Method> methods = BotOfYNApplication.eventMethodMap.get(Const.EventHandler.FriendMsgEvent.getEvent());
//            for (Method method : methods) {
//                try {
//                    method.invoke(applicationContext.getBean(method.getDeclaringClass()), Convert.convert(FriendMessageEvent.class, event));
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        } else if (event.getClass() == GroupMessageEvent.class) {    //如果是群消息事件,交给群消息处理器
//            List<Method> methods = BotOfYNApplication.eventMethodMap.get(Const.EventHandler.GroupMsgEvent.getEvent());
//            for (Method method : methods) {
//                try {
//                    method.invoke(applicationContext.getBean(method.getDeclaringClass()), Convert.convert(GroupMessageEvent.class, event));
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
////            groupMessageHandler.hello(Convert.convert(GroupMessageEvent.class, event));
//        }
    }


}
