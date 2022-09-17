package cn.yn.sever.botComon.annotation;

import java.lang.annotation.*;
import java.util.function.Predicate;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FriendMsgHandler {
    long value() default -1;

}
