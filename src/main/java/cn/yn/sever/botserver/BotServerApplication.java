package cn.yn.sever.botserver;

import cn.hutool.core.thread.ThreadUtil;
import cn.yn.sever.botserver.bean.BotsOfYN;
import cn.yn.sever.botserver.service.Test01;
import cn.yn.sever.botserver.service.Test02;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
public class BotServerApplication {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(BotServerApplication.class, args);
    }


}
