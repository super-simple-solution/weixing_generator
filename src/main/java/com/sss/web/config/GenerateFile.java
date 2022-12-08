package com.sss.web.config;

import lombok.Data;

/**
 * @author liyanan
 * @date 2022/12/08 15:21
 **/
@Data
public class GenerateFile {
    String ormName;
    String xmlName;
    String tableName;
    String mapperFileName;

    // controller 相关变量
    String create;
    String update;
    String delete;
    String list;
    String requestMapping;
    String protoObjName;
}
