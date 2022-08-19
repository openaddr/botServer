package cn.yn.sever.botserver.service;

import cn.hutool.core.thread.ThreadUtil;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;

public class Test01 {
    public static void main(String[] args) {
//        BotFactory.INSTANCE.newBot(2166675797l, "y1475369", new BotConfiguration() {{
//            fileBasedDeviceInfo();
//        }}).login();

        Thread thread2 = ThreadUtil.newThread(() -> {
            while (true) {

                System.out.println("1");
            }
        }, "Thread2", true);
        thread2.run();
    }
}
