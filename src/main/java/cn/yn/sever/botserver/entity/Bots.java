package cn.yn.sever.botserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class Bots {
    //如果配置文件中未配置QQ号,则数组为NULL!!!
    private List<QQ> yn;
    private List<QQ> ywh;
}
