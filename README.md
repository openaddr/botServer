# 工程简介

### 注解驱动开发:

##### 支持注解:

    @FriendMsgHandler
    @GroupMsgHandler

##### 使用方式

    1.将处理类交给Spring接管(加上@Component,@Service等注解即可)
    2.在处理类的某些方法上加上@FriendMsgHandler,并且保证方法的参数为FriendMessageEvent

    完成以上步骤,机器人收到好友消息事件时,就会自动调用这些方法.
    群组消息同理.
    注意,如果有多个方法都标注了这个注解,那么当事件触发时,这些方法会依次执行,至于执行顺序,我也不知道

# 延伸阅读

