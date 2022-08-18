package cn.yn.sever.botserver;

import cn.yn.sever.botserver.bean.MyBots;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class BotServerApplicationTests {

    @Resource(name = "botsOfYN")
    MyBots myBots;

    @Resource(name = "botsOfYWH")
    MyBots myBotsOfYWH;

    @Test
    void contextLoads() {
        System.out.println(myBots.getBots());
        System.out.println(myBotsOfYWH.getBots());
        myBots.getBots().forEach(x -> {
            x.login();
        });
//        myBotsOfYWH.getBots().forEach(x -> {
//            x.login();
//        });
    }

}
