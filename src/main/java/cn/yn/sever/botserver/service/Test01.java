package cn.yn.sever.botserver.service;

import cn.hutool.core.thread.ThreadUtil;
import cn.yn.sever.botserver.bean.BotsOfYN;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test01 {

    BotsOfYN botsOfYN;

    public Test01(BotsOfYN botsOfYN) {
        this.botsOfYN = botsOfYN;
//        ThreadUtil.newThread(()->{
//            System.out.println(botsOfYN.getBots());
//        },"00").start();

//        this.botsOfYN.getBots().get(1).login();
    }

}
