package cn.yn.sever.botserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import java.util.concurrent.ExecutionException;


@EnableAspectJAutoProxy
@SpringBootApplication
public class BotOfYNApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(BotOfYNApplication.class, args);
    }

}
