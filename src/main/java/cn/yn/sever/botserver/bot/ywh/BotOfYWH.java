package cn.yn.sever.botserver.bot.ywh;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;

public class BotOfYWH {
    public static void main(String[] args) {
        Bot bot = BotFactory.INSTANCE.newBot(3179299120l, "yan0906...", new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();

        BotOfYWH.afterLogin(bot);
    }

    private static void afterLogin(Bot bot) {
        /*long ywhQQNumber = 2991919296l;
        long ywhNumber = 1151703750l;
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {
            if (event.getSender().getId() == ywhQQNumber || event.getSender().getId() == ywhNumber) {
                event.getSubject().sendMessage(new MessageChainBuilder()
                        .append(new QuoteReply(event.getMessage()))
                        .append("Hi, you just said: '")
                        .append(event.getMessage())
                        .append("'")
                        .build()
                );
            }
        });*/

        System.out.println("!!!GET IT!!!");
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, friendMessageEvent -> {
            Friend sender = friendMessageEvent.getSender();

            if (sender(sender)) {
                sender.sendMessage(new QuoteReply(friendMessageEvent.getMessage()).plus("少侠，别来无恙。"));
            }
        });
    }

    private static boolean sender(Friend sender){
        long senderId = sender.getId();
        HashSet<Long> userUidList = UserUidEntity.userUidList;
        return userUidList.contains(senderId);
    }


}
