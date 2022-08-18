package cn.yn.sever.botserver.bean;

import cn.yn.sever.botserver.entity.Bots;
import cn.yn.sever.botserver.entity.QQ;
import lombok.Data;

import java.util.List;

@Data
public class ConfigBean {
    private List<Long> targetQQ;
    private Bots bots;
}
