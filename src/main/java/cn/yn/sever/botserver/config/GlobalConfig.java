package cn.yn.sever.botserver.config;

import cn.hutool.setting.yaml.YamlUtil;
import cn.yn.sever.botserver.bean.BotsOfYN;
import cn.yn.sever.botserver.bean.BotsOfYWH;
import cn.yn.sever.botserver.bean.ConfigBean;
import cn.yn.sever.botserver.bean.MyBots;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public BotsOfYN botsOfYN(ConfigBean configBean) {
        return new BotsOfYN(configBean.getBots().getYn());
    }

    @Bean
    public BotsOfYWH botsOfYWH(ConfigBean configBean) {
        return new BotsOfYWH(configBean.getBots().getYwh());
    }

    @Bean
    public ConfigBean getConfigBean() {
        return YamlUtil.loadByPath("config.yml", ConfigBean.class);
    }
}
