package com.github.yingzhuo.junitdemo.service;

import com.github.yingzhuo.junitdemo.util.SleepUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String text) {
//        SleepUtils.sleep(Duration.ofSeconds(3L));
        return text;
    }

}
