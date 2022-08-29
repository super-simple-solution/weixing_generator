package com.sss.web.util;

import com.sss.web.config.GeneratorConfig;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author liyanan
 * @date 2022/08/26 17:20
 **/
@Slf4j
public class GeneratorUtil {

    private static GeneratorConfig generatorConfig;

    public static void setGeneratorConfig(GeneratorConfig generatorConfig) {
        GeneratorUtil.generatorConfig = generatorConfig;
    }

    private GeneratorUtil() {

    }

    @SneakyThrows
    public static void testCreateMapper() {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        // create mapper
        copyFileWithOurRule(courseFile, generatorConfig.getTemplateMapper(), generatorConfig.getMapperFileName());
        copyFileWithOurRule(courseFile, generatorConfig.getTemplateMapperXml(), generatorConfig.getXmlName());
    }


    @SneakyThrows
    private static void copyFileWithOurRule(String parent, String templateFile, String newFile) {
        templateFile = parent + templateFile;
        newFile = parent + newFile;
        File file = new File(newFile);
        if (file.exists()) {
            log.info("file exist: {}", newFile);
            return;
        }

        InputStream f = new FileInputStream(templateFile);
        @Cleanup
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f, StandardCharsets.UTF_8));

        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), StandardCharsets.UTF_8)));
        bufferedReader.lines().forEach(str -> {
            str = str.replaceAll("Template", generatorConfig.getOrmName())
                    .replaceAll("tableName", generatorConfig.getTableName());

            try {
                bw.write(str);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                log.info("write error: {}", e.toString());
            }
        });

        log.info("create file success：{}", newFile);
        bw.flush();
    }
}
