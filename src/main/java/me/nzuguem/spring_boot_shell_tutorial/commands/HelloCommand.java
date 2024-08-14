package me.nzuguem.spring_boot_shell_tutorial.commands;

import me.nzuguem.spring_boot_shell_tutorial.services.HelloService;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.command.annotation.ExitCode;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class HelloCommand {

    private final HelloService helloService;

    public HelloCommand(HelloService helloService) {
        this.helloService = helloService;
    }

    @ShellMethod(key = "hello", value = "Tell me hello !")
    public String hello(
            @ShellOption(defaultValue = "Kevin", value = { "--name", "-n"}) String name
    ) {
        return this.helloService.hello(name);
    }

    @ShellMethod(key = "crash", value = "Crash all !")
    public String crash() {
        throw new RuntimeException("Crash all");
    }

    @ExceptionResolver
    @ExitCode(code = 5)
    private String errorHandler(RuntimeException e) {
        return "Hi, handled exception : " + e.getMessage();
    }
}
