package cn.yn.sever.botserver.listener;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.reflect.MethodHandleUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.json.JSONUtil;
import cn.yn.sever.botserver.handler.FriendMessageHandler;
import cn.yn.sever.botserver.handler.GroupMessageHandler;
import cn.yn.sever.botserver.iconst.Const;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
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

    public static Map<Class<? extends Event>, List<Method>> eventMethodMap = new HashMap<>();

    /**
     * 自动将枚举类中的所有注解所修饰的方法与其对应的事件对象绑定
     */
    static {
        Set<Class<?>> classes = ClassUtil.scanPackage("cn.yn.sever.botserver.handler");
        for (Class<?> aClass : classes) {
            for (Const.EventHandler eventHandler : Const.EventHandler.values()) {
                List<Method> methods = ClassUtil.getPublicMethods(aClass, x -> x.isAnnotationPresent(eventHandler.getAnnotation()));
                List<Method> tempMethods = eventMethodMap.putIfAbsent(eventHandler.getEvent(), methods);
                if (tempMethods != null) {
                    tempMethods.addAll(methods);
                }
            }
        }
    }

    /**
     * 监听所有事件,根据事件类型交给不同的handler处理
     *
     * @param event
     */
    public void messageListener(Event event) {
        for (Const.EventHandler eventHandler : Const.EventHandler.values()) {
            if (event.getClass() == eventHandler.getEvent()) {
                List<Method> methods = eventMethodMap.get(eventHandler.getEvent());
                for (Method method : methods) {
                    MethodHandleUtil.invoke(applicationContext.getBean(method.getDeclaringClass()), method, event);
                }
            }
        }
    }


}
