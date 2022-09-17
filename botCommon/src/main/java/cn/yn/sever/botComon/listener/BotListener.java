package cn.yn.sever.botComon.listener;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.reflect.MethodHandleUtil;
import cn.hutool.core.util.ClassUtil;
import cn.yn.sever.botComon.iconst.Const;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BotListener {
    @Autowired
    ApplicationContext applicationContext;

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
        //遍历枚举
        for (Const.EventHandler eventHandler : Const.EventHandler.values()) {
            //如果事件类型是目标枚举类型,则执行目标枚举所指定的注解所标识的方法
            if (event.getClass() == eventHandler.getEvent()) {
                //获取到目标事件所对应的方法
                List<Method> methods = eventMethodMap.get(eventHandler.getEvent());
                //对方法进行遍历执行
                for (Method method : methods) {
                    //判断改方法是否应该执行
//                    boolean doIt = isDoIt(event, eventHandler, method);
//                    if (doIt) {
                    MethodHandleUtil.invoke(applicationContext.getBean(method.getDeclaringClass()), method, event);
//                    }
                }
            }
        }
    }
//
//    /**
//     * todo
//     *  做判断
//     *
//     * @param event
//     * @param eventHandler
//     * @param method
//     * @return
//     */
//    private boolean isDoIt(Event event, Const.EventHandler eventHandler, Method method) {
//        boolean doIt = false;
//        if (event instanceof FriendEvent) {
//            FriendEvent friendEvent = (FriendEvent) event;
//            Long id = AnnotationUtil.getAnnotationValue(method, eventHandler.getAnnotation(), "id");
//            if (friendEvent.getFriend().getId() == id) {
//                doIt = true;
//            }
//        } else {
//            doIt = true;
//        }
//        return doIt;
//    }


}
