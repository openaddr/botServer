package cn.yn.sever.botserver.theConst;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 全局常量类
 */
@Component
@Data
public class GlobalConst {

    //Ctrl + 左键点击 可以跳转到yml文件中，说明路径映射正确
    @Value("${bot.yn.loginId}")
    private String loginId;

    @Value("${bot.yn.loginPwd}")
    private String loginPwd;
}
