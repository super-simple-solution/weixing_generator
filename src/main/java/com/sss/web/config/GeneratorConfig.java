package com.sss.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liyanan
 * @date 2022/08/26 17:24
 **/
@Component
@ConfigurationProperties(prefix = "genefile")
@Data
public class GeneratorConfig {
    String ormName;
    String templateMapper;
    String templateMapperXml;
    String xmlName;
    String tableName;
    String mapperFileName;
}
