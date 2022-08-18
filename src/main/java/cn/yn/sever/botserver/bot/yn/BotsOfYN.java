package cn.yn.sever.botserver.bot.yn;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.yn.sever.botserver.bean.ConfigBean;
import cn.yn.sever.botserver.entity.QQ;
import lombok.Data;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
//@Component
//此注解的作用是：单元测试时不会加载此bean
//@ConditionalOnMissingBean(name = "org.springframework.boot.test.mock.mockito.MockitoPostProcessor")
public class BotsOfYN {

    private List<Bot> bots;
    @Autowired
    ConfigBean configBean;
    private List<QQ> qqList;

    public void setQqList() {
        this.qqList = configBean.getBots().getYn();
    }

    /**
     * 根据配置文件自动(批量)注入Bot
     *
     */
    public BotsOfYN() {
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


    public void afterLogin(Bot bot) {
        long yourQQNumber = 2413823382l;
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {
            if (event.getSender().getId() == yourQQNumber) {
                event.getSubject().sendMessage(
                        new MessageChainBuilder()
                                .append(new QuoteReply(event.getMessage()))
                                .append("Hi, you just said: '")
                                .append(event.getMessage())
                                .append("'")
                                .build());
            }
        });
    }
}
