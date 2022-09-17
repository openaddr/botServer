package cn.yn.sever.botComon.bean;

import lombok.Data;

import java.util.List;

@Data
public class ConfigBean {
    private List<Long> targetQQ;
    private BotConfig botConfig;
}
