package cn.yn.sever.botserver.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class YamlEntity {




    private List<QQ> test = new ArrayList<>();

    @Data
    public class QQ {
        private Long id;
        private String pwd;
    }
}
