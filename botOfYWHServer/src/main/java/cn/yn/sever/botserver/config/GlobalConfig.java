package cn.yn.sever.botserver.config;

import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botComon.aop.MyAop;
import cn.yn.sever.botComon.bean.ConfigBean;
import cn.yn.sever.botComon.listener.BotListener;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类,
 * 会在启动时自动注入一些类
 */
@Configuration
public class GlobalConfig {
    /**
     * 监听器
     * @return
     */
    @Bean
    public BotListener botListener() {
        return new BotListener();
    }

    /**
     * 切面增强
     * @return
     */
    @Bean
    public MyAop myAop(){
        return new MyAop();
    }

    /**
     * 自动注入Bot并登陆,随后被监听
     * @param configBean
     * @return
     */
    @Bean
    @ConditionalOnBean(BotListener.class)
    public Bot botOfYWH(ConfigBean configBean,BotListener botListener) {
        Bot bot = BotFactory.INSTANCE.newBot(configBean.getBotConfig().getId(), configBean.getBotConfig().getPwd(), new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();
        bot.getEventChannel().subscribeAlways(Event.class, botListener::messageListener);
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
