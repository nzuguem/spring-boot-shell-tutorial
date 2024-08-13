package me.nzuguem.spring_boot_shell_tutorial.commands;

import me.nzuguem.spring_boot_shell_tutorial.utils.LoggerUtils;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class LogCommand {

    @ShellMethod(value = "Log a message", key = "log")
    public void log(
          @ShellOption String message
    ) {
        LoggerUtils.log(message);
    }
}
