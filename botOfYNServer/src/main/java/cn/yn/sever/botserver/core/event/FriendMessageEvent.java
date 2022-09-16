package cn.yn.sever.botserver.core.event;

import lombok.Data;
import net.mamoe.mirai.message.data.Message;
import net.mamoe.mirai.message.data.MessageChain;

@Data
public  class FriendMessageEvent implements UserMessageEvent {
    private String senderName;
    static Message message;

    public static void main(String[] args) {


    }
}
