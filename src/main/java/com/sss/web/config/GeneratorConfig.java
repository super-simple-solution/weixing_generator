package com.sss.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liyanan
 * @date 2022/08/26 17:24
 **/
@Component
@ConfigurationProperties(prefix = "genefile")
@Data
public class GeneratorConfig {
  private String mapperPackage;
  private String mapperExtPath;
  private String templateDirName;
  private String javafilePath;
  private String servicePackage;
  private String baseServicePackage;
  private String entityPackage;
  private String controllerPackage;

  private List<GenerateFile> generateFiles;
}
