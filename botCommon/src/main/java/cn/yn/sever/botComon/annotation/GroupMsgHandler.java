package cn.yn.sever.botComon.annotation;


import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GroupMsgHandler {
}
