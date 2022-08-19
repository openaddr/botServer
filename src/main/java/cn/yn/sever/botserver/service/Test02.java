package cn.yn.sever.botserver.service;

import cn.hutool.core.thread.ThreadUtil;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = ThreadUtil.newThread(() -> {
            BotFactory.INSTANCE.newBot(2159094392l, "y1475369", new BotConfiguration() {{
                fileBasedDeviceInfo();
            }}).login();
        }, "Thread1", true);
        thread.start();

        thread.join();

    }
}
