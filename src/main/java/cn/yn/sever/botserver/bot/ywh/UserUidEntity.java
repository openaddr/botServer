package cn.yn.sever.botserver.bot.ywh;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

@Data
@Slf4j
public class UserUidEntity {
    public static HashSet<Long> userUidList;



    static {
        Properties properties = new Properties();
        String propertyName = "userUid.properties";
        ClassPathResource classPathResource = new ClassPathResource(propertyName);
        try {
            properties.load(classPathResource.getInputStream());
            String userUidString = properties.getProperty("userUidList");
            userUidList = getSenderList(userUidString);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private static HashSet<Long> getSenderList(String userUidString){
        String[] split = userUidString.split(",");
        HashSet<Long> senderList = new HashSet<>();
        List<String> userUidList = Arrays.asList(split);
        userUidList.forEach(userUid -> senderList.add(Long.valueOf(userUid)));
        return senderList;
    }
}
