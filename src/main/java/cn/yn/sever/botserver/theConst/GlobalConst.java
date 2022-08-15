package cn.yn.sever.botserver.theConst;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 全局常量类
 */
@Component
@Data
//@ConfigurationProperties(prefix = "test.qq")
public class GlobalConst {

    //Ctrl + 左键点击 可以跳转到yml文件中，说明路径映射正确
//    @Value("${bot.yn.loginId}")
    private String loginId;

//    @Value("${bot.yn.loginPwd}")
    private String loginPwd;

//        @Value("${qq}")
    private List<Map<String, String>> qq;

}
