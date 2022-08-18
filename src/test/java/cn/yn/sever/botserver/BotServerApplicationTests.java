package cn.yn.sever.botserver;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botserver.entity.YamlEntity;
import cn.yn.sever.botserver.theConst.GlobalConst;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BotServerApplicationTests {

    @Autowired
    ConfigBean bean;

    @Autowired
    BotsOfYN botsOfYN;

    @Test
    void contextLoads() {
        System.out.println(botsOfYN.getBots());
    }


    @Test
    void t1(){
        YamlEntity yaml = YamlUtil.loadByPath("config.yml", YamlEntity.class);
        System.out.println(yaml);

    }

    @Test
    void t2() {
        Map<String, Object> map = new HashMap<>();
        map.put("verifyKey", "j5sNJbVdcPaySZt7");
        String post = HttpUtil.post("http://localhost:4040/verify", JSONUtil.toJsonStr(map));
        System.out.println(post);
    }

    }

}
