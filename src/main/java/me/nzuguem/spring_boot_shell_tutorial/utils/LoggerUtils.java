package me.nzuguem.spring_boot_shell_tutorial.utils;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public final class LoggerUtils {

    private LoggerUtils() {
    }

    public static void log(String message) {

        System.out.printf("%s - %s%n", Instant.now(Clock.tickMillis(ZoneId.systemDefault())), message);
    }

}
