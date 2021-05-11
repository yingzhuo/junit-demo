package com.github.yingzhuo.junitdemo.service;

import com.github.yingzhuo.junitdemo.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EchoServiceTestCase {

    private static final String TEXT = "text";

    @Autowired
    private EchoService echoService;

    @BeforeAll
    public static void beforeAll() {
        log.info("execute beforeAll()");
    }

    @BeforeEach
    public void before() {
        log.info("execute beforeEach()");
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 5)
    @DisplayName("测试echo方法 - 1")
    @Order(1)
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "只有在windows系统上才测试")
    public void echo1() {
        val result = echoService.echo(TEXT);
        Assertions.assertEquals(TEXT, result);
    }

    @Test
    @DisplayName("测试echo方法 - 2")
    @Order(1)
    @EnabledOnOs(OS.MAC)
    public void echo2() {
        val result = echoService.echo(TEXT);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.length());
    }

}
