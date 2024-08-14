package me.nzuguem.spring_boot_shell_tutorial.commands;

import me.nzuguem.spring_boot_shell_tutorial.models.Fruit;
import me.nzuguem.spring_boot_shell_tutorial.services.FruitService;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@ShellCommandGroup
public class FruitCommand {

    private final FruitService fruitService;

    public FruitCommand(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @ShellMethod(key = "fruit all", value = "Get all fruits")
    public List<Fruit> all() {
        return this.fruitService.findAll();
    }
}
