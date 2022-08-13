package cn.yn.sever.botserver;

import cn.yn.sever.botserver.theConst.GlobalConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BotServerApplicationTests {

    @Autowired
    GlobalConst globalConst;

    @Test
    void contextLoads() {

        System.out.println(globalConst.getLoginId());
        System.out.println(globalConst.getLoginPwd());
    }

}
