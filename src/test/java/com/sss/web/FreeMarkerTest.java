package com.sss.web;

import com.sss.web.config.GeneratorConfig;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyanan
 * @date 2022/09/14 15:28
 **/
@SpringBootTest
public class FreeMarkerTest {

    @Resource
    private GeneratorConfig generatorConfig;

    @Test
    @SneakyThrows
    public void test() {
        //从config对象中获得模板对象。需要制定一个模板文件的名字。
        //创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。
        Map<String, String> root = new HashMap<>();
        root.put("package_name", "com.sss.web.mapper");
        root.put("entity_name", "Department");
        root.put("id_type", "Integer");
//        FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "mapper.ftl", generatorConfig.getMapperFileName(), root);
    }
}
