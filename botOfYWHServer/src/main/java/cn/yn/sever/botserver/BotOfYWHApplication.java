package cn.yn.sever.botserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class BotOfYWHApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(BotOfYWHApplication.class, args);
    }

}
