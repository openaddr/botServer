package cn.yn.sever.botserver.bean;

import cn.yn.sever.botserver.entity.QQ;
import net.mamoe.mirai.Bot;

import java.util.Iterator;
import java.util.List;

public class BotsOfYN extends MyBots{
    public BotsOfYN(List<QQ> qqList) {
        super(qqList);
        this.allLogin();
    }

    public void allLogin(){
        List<Bot> bots = super.getBots();
        bots.get(0).login();
        Iterator<Bot> iterator = bots.iterator();
        while (iterator.hasNext()){

            Bot next = iterator.next();
            System.out.println(next);
//            next.login();
        }
    }
}
