package com.sss.web.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author liyanan
 * @date 2022/09/14 15:43
 **/
@Slf4j
public class FreeMarkerUtil {
    private FreeMarkerUtil() {

    }

    private static Configuration configuration = null;

    private static Configuration getInstance(String templateDirName) throws IOException {
        if (configuration == null) {
            configuration = new Configuration(Configuration.getVersion());
            // 告诉config对象模板文件存放的路径。
            configuration.setDirectoryForTemplateLoading(new File(templateDirName));
            // 设置config的默认字符集。一般是utf-8
            configuration.setDefaultEncoding("utf-8");
        }
        return configuration;
    }

    public static void generatorFile(String templateDirName, String templateName, String originFileName, Map<String, String> dataModel) {
        if (new File(originFileName).exists()) {
            log.error("{} exist!", originFileName);
            return;
        }
        //从config对象中获得模板对象。需要制定一个模板文件的名字。
        try (Writer out = new FileWriter(originFileName)) {
            Template template = FreeMarkerUtil.getInstance(templateDirName).getTemplate(templateName);
            //调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
            template.process(dataModel, out);
        } catch (Exception e) {
            log.error("generatorFile error: {}", e.toString());
        }
    }

}
