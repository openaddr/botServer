package cn.yn.sever.botserver.bot;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;

public class MiraiTest {
    public static void main(String[] args) {
        Bot bot = BotFactory.INSTANCE.newBot(2357902824l, "y1475369", new BotConfiguration() {{
            fileBasedDeviceInfo();
        }});
        bot.login();


        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, friendMessageEvent -> {
            Friend sender = friendMessageEvent.getSender();

            if (sender.getId() == 2413823382l) {
                sender.sendMessage(new QuoteReply(friendMessageEvent.getMessage()).plus("少侠，别来无恙。"));
            }
        });
    }

}
