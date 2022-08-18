package cn.yn.sever.botserver.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.yn.sever.botserver.bean.ConfigBean;
import cn.yn.sever.botserver.entity.QQ;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BotsOfUs {

    private List<Bot> bots;
    @Autowired
    ConfigBean configBean;


    public BotsOfUs(List<QQ> qqList) {
    }

    /**
     * 根据配置文件自动(批量)注入Bot
     *
     * @param configBean
     */
    public BotsOfUs(ConfigBean configBean,List<QQ> qqList) {
//        List<QQ> qqList = configBean.getBots().getYn();
        if (CollUtil.isNotEmpty(qqList)) {
            List<QQ> validQQList = qqList.stream().filter(ObjectUtil::isAllNotEmpty).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(validQQList)) {
                bots = new ArrayList<>(validQQList.size());
                for (QQ qq : validQQList) {
                    bots.add(BotFactory.INSTANCE.newBot(qq.getId(), qq.getPwd(), new BotConfiguration() {{
                        fileBasedDeviceInfo();
                    }}));
                }
            }
        }
    }
}
