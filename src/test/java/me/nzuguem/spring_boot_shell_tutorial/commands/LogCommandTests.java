package me.nzuguem.spring_boot_shell_tutorial.commands;

import me.nzuguem.spring_boot_shell_tutorial.BaseCommandTests;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.shell.test.ShellAssertions;

import java.util.concurrent.TimeUnit;

public class LogCommandTests extends BaseCommandTests {

    @Test
    void Should_log_message_when_log_command() {

        var session = client
                .nonInterative("log", "Welcome")
                .run();

        Awaitility.await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen())
                    .containsText("Welcome");
        });
    }
}
