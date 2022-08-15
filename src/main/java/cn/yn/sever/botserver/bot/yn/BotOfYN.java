package cn.yn.sever.botserver.bot.yn;

import cn.hutool.core.convert.Convert;
import cn.yn.sever.botserver.theConst.GlobalConst;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
//此注解的作用是：单元测试时不会加载此bean
@ConditionalOnMissingBean(name = "org.springframework.boot.test.mock.mockito.MockitoPostProcessor")
public class BotOfYN {

    @Autowired
    GlobalConst globalConst;

    public BotOfYN(GlobalConst globalConst) {
        Bot bot = BotFactory.INSTANCE.newBot(Convert.toLong(globalConst.getLoginId()), globalConst.getLoginPwd(), new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();
        afterLogin(bot);
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
