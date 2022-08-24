package cn.yn.sever.botserver.config;

import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botserver.bean.ConfigBean;
import cn.yn.sever.botserver.listener.BotListener;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类,
 * 会在启动时自动注入一些类
 */
@Configuration
public class GlobalConfig {

    static BotListener botListener;

    @Autowired
    public void setBotListener(BotListener botListener) {
       GlobalConfig.botListener = botListener;
    }

    /**
     * 自动注入Bot并登陆,随后被监听
     * @param configBean
     * @return
     */
    @Bean
    @ConditionalOnBean(BotListener.class)
    public Bot botOfYWH(ConfigBean configBean) {
        Bot bot = BotFactory.INSTANCE.newBot(configBean.getBotConfig().getId(), configBean.getBotConfig().getPwd(), new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();
        bot.getEventChannel().subscribeAlways(Event.class, event -> {
            botListener.messageListener(event);
        });
        return bot;
    }

    /**
     * 自动注入配置类
     * @return
     */
    @Bean
    public ConfigBean getConfigBean() {
        return YamlUtil.loadByPath("config.yml", ConfigBean.class);
    }

}
