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
    GlobalConst globalConst;

    @Test
    void contextLoads() {
        YamlEntity yamlEntity = new YamlEntity();

        YamlEntity.QQ qq = yamlEntity.new QQ();
        qq.setId(23145l);
        qq.setPwd("21635464");
        YamlEntity.QQ qq1 = yamlEntity.new QQ();
        qq1.setId(21654l);
        qq1.setPwd("486498");


        System.out.println(JSONUtil.toJsonStr(yamlEntity));
//        System.out.println(globalConst.getLoginId());
//        System.out.println(globalConst.getLoginPwd());

//        List<Map<String, String>> qq = globalConst.getQq();
//        System.out.println(qq);
//        qq.forEach(System.out::println);

//        Dict dict = YamlUtil.loadByPath("application.yml");
//
//        System.out.println(dict);
    }


    @Test
    void t1(){
        YamlEntity yaml = YamlUtil.loadByPath("config.yml", YamlEntity.class);
        System.out.println(yaml);

    }

    @Test
    void t2(){

    }

}
