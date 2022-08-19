package cn.yn.sever.botserver.config;

import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botserver.bean.ConfigBean;
import cn.yn.sever.botserver.service.impl.BotListener;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

//    @Autowired
//    BotListener botListener;
    @Bean
    @ConditionalOnBean(BotListener.class)
    public Bot botsOfYN(ConfigBean configBean) {
        Bot bot = BotFactory.INSTANCE.newBot(configBean.getBotConfig().getId(), configBean.getBotConfig().getPwd(), new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();
        bot.getEventChannel().subscribeAlways(Event.class, event -> {
            BotListener.messageListener(event);
        });
        return bot;
    }

    @Bean
    public ConfigBean getConfigBean() {
        return YamlUtil.loadByPath("config.yml", ConfigBean.class);
    }

}
