package com.github.yingzhuo.junitdemo.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class EchoServiceTestCases {

    private static final String TEXT = "text";

    @Autowired
    EchoService echoService;

    @BeforeAll
    static void beforeAll() {
        log.info("execute beforeAll()");
    }

    @BeforeEach
    void before() {
        log.info("execute beforeEach()");
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 5)
    @DisplayName("测试echo方法")
    void echo1() {
        val result = echoService.echo(TEXT);
        assertThat(result).isEqualTo(TEXT);
    }

}
