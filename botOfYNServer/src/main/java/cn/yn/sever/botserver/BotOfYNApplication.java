package cn.yn.sever.botserver;

import cn.hutool.core.util.ClassUtil;
import cn.yn.sever.botserver.iconst.Const;
import net.mamoe.mirai.event.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;


@EnableAspectJAutoProxy
@SpringBootApplication
public class BotOfYNApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(BotOfYNApplication.class, args);
    }

}
