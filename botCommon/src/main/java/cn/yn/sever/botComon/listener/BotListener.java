package cn.yn.sever.botComon.listener;

import cn.hutool.core.lang.reflect.MethodHandleUtil;
import cn.hutool.core.util.ClassUtil;
import cn.yn.sever.botComon.iconst.Const;
import net.mamoe.mirai.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

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
