package cn.yn.sever.botserver.bean;

import cn.yn.sever.botserver.entity.BotConfig;
import lombok.Data;

import java.util.List;

@Data
public class ConfigBean {
    private List<Long> targetQQ;
    private BotConfig botConfig;
}
