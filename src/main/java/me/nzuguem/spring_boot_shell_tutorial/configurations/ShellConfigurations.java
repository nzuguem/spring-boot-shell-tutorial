package me.nzuguem.spring_boot_shell_tutorial.configurations;

import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellConfigurations {


    // For Interactive ShellRunner
    @Bean
    public PromptProvider promptProvider() {
        return () -> AttributedString.fromAnsi("spring-boot-shell-tutorial> ");
    }

}
