package com.sss.web.util;

import com.sss.web.config.GeneratorConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GeneratorUtilTest {

    @Resource
    private GeneratorConfig generatorConfig;

    @BeforeEach
    public void init() {
        GeneratorUtil.setGeneratorConfig(generatorConfig);
    }

    @Test
    void testCreateMapper() {
        GeneratorUtil.testCreateMapper();
    }
}