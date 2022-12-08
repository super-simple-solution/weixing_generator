package com.sss.web.util;

import com.sss.web.config.GeneratorConfig;
import com.sss.web.config.GenerateFile;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

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
    public static void createMapper() {
        //从config对象中获得模板对象。需要制定一个模板文件的名字。
        //创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。
        Map<String, String> root = new HashMap<>();
        for (GenerateFile generateFile : generatorConfig.getGenerateFiles()) {
            root.put("mapper_package_name", generatorConfig.getMapperPackage());
            root.put("entity_name", generateFile.getOrmName());
            root.put("id_type", "Integer");
            root.put("table_name", generateFile.getTableName());
            String xmlName = generatorConfig.getMapperExtPath() + "/" + generateFile.getOrmName() + "MapperExt.xml";
            String mapperName = generatorConfig.getJavafilePath() +"/"+ generatorConfig.getMapperPackage().replaceAll("\\.", "/") + "/" + generateFile.getOrmName() + "Mapper.java";
            FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "mapper.ftl", mapperName, root);
            FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "mapperExt.ftl", xmlName, root);
        }
    }

    @SneakyThrows
    public static void createService() {
        //从config对象中获得模板对象。需要制定一个模板文件的名字。
        //创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。
        Map<String, String> root = new HashMap<>();
        for (GenerateFile generateFile : generatorConfig.getGenerateFiles()) {
            root.put("service_package", generatorConfig.getServicePackage());
            root.put("entity_name", generateFile.getOrmName());
            root.put("entity_package", generatorConfig.getEntityPackage());
            root.put("base_service_package", generatorConfig.getBaseServicePackage());
            root.put("id_type", "Integer");
            String serviceName = generatorConfig.getJavafilePath() +"/"+ generatorConfig.getServicePackage().replaceAll("\\.", "/") + "/" + generateFile.getOrmName() + "Service.java";
            String serviceImplName = generatorConfig.getJavafilePath() +"/"+ generatorConfig.getServicePackage().replaceAll("\\.", "/") + "/" + generateFile.getOrmName() + "ServiceImpl.java";
            FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "service.ftl", serviceName, root);
            FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "serviceImpl.ftl", serviceImplName, root);
        }
    }


    @SneakyThrows
    public static void createController() {
        //从config对象中获得模板对象。需要制定一个模板文件的名字。
        //创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。
        Map<String, String> root = new HashMap<>();
        for (GenerateFile generateFile : generatorConfig.getGenerateFiles()) {
            root.put("controller_package", generatorConfig.getControllerPackage());
            root.put("request_mapping", generateFile.getRequestMapping());
            root.put("entity_name", generateFile.getOrmName());
            root.put("create", generateFile.getCreate());
            root.put("delete", generateFile.getDelete());
            root.put("update", generateFile.getUpdate());
            root.put("list", generateFile.getList());
            root.put("proto_obj_name", generateFile.getProtoObjName());
            String controllerName = generatorConfig.getJavafilePath() +"/"+ generatorConfig.getControllerPackage().replaceAll("\\.", "/") + "/" + generateFile.getOrmName() + "Controller.java";
            FreeMarkerUtil.generatorFile(generatorConfig.getTemplateDirName(), "controller.ftl", controllerName, root);
        }
    }

    @SneakyThrows
    public static void createAll() {
        createMapper();
        createService();
        createController();
    }
}
