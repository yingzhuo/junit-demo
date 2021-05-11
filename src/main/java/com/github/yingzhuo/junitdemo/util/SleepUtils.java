package com.github.yingzhuo.junitdemo.util;

import lombok.SneakyThrows;

import java.time.Duration;

public final class SleepUtils {

    private SleepUtils() {
    }

    @SneakyThrows
    public static void sleep(Duration duration) {
        if (duration != null) {
            Thread.sleep(duration.toMillis());
        }
    }

}
