package cn.yn.sever.botserver.bean;

import cn.yn.sever.botserver.entity.QQ;
import net.mamoe.mirai.Bot;

import java.util.List;

public class BotsOfYWH extends MyBots{
    public BotsOfYWH(List<QQ> qqList) {

        this.allLogin();
    }

    public void allLogin(){
//        super.getBots().forEach(Bot::login);
    }
}
