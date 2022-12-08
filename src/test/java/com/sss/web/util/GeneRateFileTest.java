//package com.sss.web.util;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//
///**
// *
// * 用来第一次生成 Mapper
// * @author liyanan
// * @date 2022/03/21/10:49
// */
//
//@ConfigurationProperties(prefix = "genefile")
//@SpringBootTest
//@Slf4j
//@Data
//public class GeneRateFileTest {
//
//    String ormName;
//    String mapperFilePath;
//    String serviceFilePath;
//    String controllerFilePath;
//    String mapperXmlFilePath;
//    String templateDirName;
//    String mapperFileName;
//    String serviceInterfaceName;
//    String serviceImplName;
//    String controllerName;
//    String xmlName;
//    String requestMapping;
//    String protoListResp;
//    String protoListReq;
//    String protoCreateResp;
//    String protoCreateReq;
//    String protoUpdateResp;
//    String protoUpdateReq;
//    String protoDeleteReq;
//    String protoDeleteResp;
//    String protoMessage;
//    String tableName;
//
//    @Test
//    public void testCreateAll() throws IOException {
//        // create mapper
//        testCreateMapper();
//        // create service
//        testCreateService();
//        // create controller
////        testCreateController();
//    }
//
//    @Test
//    public void testCreateMapper() throws IOException {
//        // create mapper
//        copyFileWithOurRule(templateDirName + "TemplateMapper.txt", mapperFilePath + mapperFileName);
//        copyFileWithOurRule(templateDirName + "TemplateMapperExt.txt", mapperXmlFilePath + xmlName);
//    }
//
//    private void copyFileWithOurRule(String templateFile, String newFile) throws IOException {
//        File file = new File(newFile);
//        if (file.exists()) {
//            log.info("file exist: {}", newFile);
//            return;
//        }
//        InputStream f = new FileInputStream(templateFile);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f, StandardCharsets.UTF_8));
//
//
//        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), StandardCharsets.UTF_8)));
//        bufferedReader.lines().forEach(str -> {
//            str = str.replaceAll("Template", ormName)
//                    .replaceAll("CreateResponse", protoCreateResp)
//                    .replaceAll("DeleteResponse", protoDeleteResp)
//                    .replaceAll("UpdateResponse", protoUpdateResp)
//                    .replaceAll("ListResponse", protoListResp)
//                    .replaceAll("CreateRequest", protoCreateReq)
//                    .replaceAll("DeleteRequest", protoDeleteReq)
//                    .replaceAll("UpdateRequest", protoUpdateReq)
//                    .replaceAll("ListRequest", protoListReq)
//                    .replaceAll("requestMapping", requestMapping)
//                    .replaceAll("protoMessage", protoMessage)
//                    .replaceAll("tableName", tableName)
//            ;
//
//            try {
//                bw.write(str);
//                bw.newLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//        log.info("create file success：{}", newFile);
//        bw.flush();
//        bw.close();
//        bufferedReader.close();
//        f.close();
//    }
//
//
//    @Test
//    public void testCreateController() throws IOException {
//        copyFileWithOurRule(templateDirName + "TemplateController.txt", controllerFilePath + controllerName);
//    }
//
//    @Test
//    public void testCreateService() throws IOException {
//        copyFileWithOurRule(templateDirName + "service.ftl", serviceFilePath + serviceInterfaceName);
//        copyFileWithOurRule(templateDirName + "serviceImpl.ftl", serviceFilePath + serviceImplName);
//    }
//
//    @Test
//    public void test111() {
//        System.out.println(xmlName);
//    }
//}
