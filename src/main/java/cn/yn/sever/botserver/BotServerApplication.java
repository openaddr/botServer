package cn.yn.sever.botserver;

import cn.hutool.core.thread.ThreadUtil;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
public class BotServerApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(BotServerApplication.class, args);

//        Future<?> async = ThreadUtil.execAsync(() -> {
//            BotFactory.INSTANCE.newBot(2166675797l, "y1475369", new BotConfiguration() {{
//                fileBasedDeviceInfo();
//            }}).login();
//        });
//        Object o = async.get();
//        System.out.println("!!!");
//        BotFactory.INSTANCE.newBot(2357902824l,"y1475369",new BotConfiguration(){{
//            fileBasedDeviceInfo();
//        }}).login();
//        BotFactory.INSTANCE.newBot(2166675797l,"y1475369",new BotConfiguration(){{
//            fileBasedDeviceInfo();
//        }}).login();
    }
}
