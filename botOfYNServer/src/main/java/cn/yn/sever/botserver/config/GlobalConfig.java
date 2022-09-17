package cn.yn.sever.botserver.config;

import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botComon.bean.ConfigBean;
import cn.yn.sever.botComon.listener.BotListener;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public BotListener botListener() {
        return new BotListener();
    }

    @Bean
    @ConditionalOnBean(BotListener.class)
    public Bot botOfYN(ConfigBean configBean, BotListener botListener) {
        Bot bot = BotFactory.INSTANCE.newBot(configBean.getBotConfig().getId(), configBean.getBotConfig().getPwd(), new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();
        bot.getEventChannel().subscribeAlways(Event.class, botListener::messageListener);
        return bot;
    }

    @Bean
    public ConfigBean getConfigBean() {
        return YamlUtil.loadByPath("config.yml", ConfigBean.class);
    }

}
