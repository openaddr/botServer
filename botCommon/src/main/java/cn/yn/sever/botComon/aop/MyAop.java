package cn.yn.sever.botComon.aop;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ClassUtil;
import cn.yn.sever.botComon.iconst.Const;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@EnableAspectJAutoProxy
@Aspect
public class MyAop {

    @Pointcut(value = "@annotation(cn.yn.sever.botComon.annotation.FriendMsgHandler)")
    public void friendMessageEvent() {
    }


    /**
     * 环绕增强,
     *  只有当
     * @param joinPoint
     * @return
     */
    @Around("friendMessageEvent()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long value = AnnotationUtil.getAnnotationValue(((MethodSignature) joinPoint.getSignature()).getMethod(), Const.EventHandler.FriendMsgEvent.getAnnotation());
        if (value==-1){ //如果注解的value为默认值-1,则直接执行
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        } else { //如果注解的value不为默认值-1,则只有当此好友消息的来源好友是注解指定的QQ号时,才会执行
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof FriendMessageEvent) {
                    FriendMessageEvent friendMessageEvent = (FriendMessageEvent) arg;
                    if (friendMessageEvent.getFriend().getId() == value) {
                        try {
                            return joinPoint.proceed();
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return null;
    }
}
