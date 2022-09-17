
### 注解驱动开发:

##### 支持注解:

    @FriendMsgHandler
    作用:
        接受到好友消息事件时,自动执行被此注解标记的方法,如果有多个方法被标记,那么这些方法会依次执行
    @GroupMsgHandler
    作用:
        接受到群消息事件时,自动执行被此注解标记的方法,如果有多个方法被标记,那么这些方法会依次执行
##### 使用方式
    @FriendMsgHandler   
    必须:
        1.创建一个类,并交给Spring管理(即标记@Component/@Service等注解即可)
        2.在此类内创建一个方法,参数类型为FriendMessageEvent
        3.给此方法标记上@FriendMsgHandler注解
    可选:
        此注解可以接受一个参数,类型为long.如果传入了参数,则只有当好友消息来源的QQ号等于所传的long值时,被标记的方法才会执行
    @GroupMsgHandler   
    必须:
        1.创建一个类,并交给Spring管理(即标记@Component/@Service等注解即可)
        2.在此类内创建一个方法,参数类型为GroupMessageEvent
        3.给此方法标记上@GroupMsgHandler注解


