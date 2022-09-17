package cn.yn.sever.botserver.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class MyAop {

    @Pointcut(value = "@annotation(cn.yn.sever.botComon.annotation.FriendMsgHandler)")
    public void friendMessageEvent(){
    }

    /**
     * 调用被@FriendMsgHandler修饰的方法前,会执行此方法内容.
     * @param joinPoint
     */
    @Before("friendMessageEvent()")
    public void before(JoinPoint joinPoint){
        System.out.println("***********WARNING***********");
    }
}
