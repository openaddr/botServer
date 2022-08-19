package cn.yn.sever.botserver.bean;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.yn.sever.botserver.entity.QQ;
import lombok.Data;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MyBots {

    public MyBots(){
        System.out.println("");
    }


    private List<Bot> bots;

    /**
     * 根据所给的QQ集合自动(批量)注入Bot
     * todo 多个QQ应该可以多线程登陆
     */
    public MyBots(List<QQ> qqList) {
        if (CollUtil.isNotEmpty(qqList)) {
            List<QQ> validQQList = qqList.stream().filter(ObjectUtil::isAllNotEmpty).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(validQQList)) {
                bots = new ArrayList<>(validQQList.size());
//                List<Bot> safeBots = Collections.synchronizedList(bots);
                for (QQ qq : validQQList) {
                    bots.add(BotFactory.INSTANCE.newBot(qq.getId(), qq.getPwd(), new BotConfiguration() {{
                        fileBasedDeviceInfo();
                    }}));
                }
            }
        }
    }
}
