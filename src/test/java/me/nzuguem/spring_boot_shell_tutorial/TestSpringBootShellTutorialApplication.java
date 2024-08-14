package me.nzuguem.spring_boot_shell_tutorial;

import me.nzuguem.spring_boot_shell_tutorial.configurations.ContainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestSpringBootShellTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringBootShellTutorialApplication::main)
                .with(ContainersConfiguration.class)
                .run(args);
    }
}
