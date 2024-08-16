package me.nzuguem.spring_boot_shell_tutorial.commands;

import me.nzuguem.spring_boot_shell_tutorial.exceptions.FruitNotFoundException;
import me.nzuguem.spring_boot_shell_tutorial.models.Fruit;
import me.nzuguem.spring_boot_shell_tutorial.services.FruitService;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.command.annotation.ExitCode;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class FruitCommand {

    private final FruitService fruitService;

    public FruitCommand(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @ShellMethod(key = "fruit all", value = "Get all fruits")
    public List<Fruit> all() {
        return this.fruitService.findAll();
    }

    @ShellMethod(key = "fruit get", value = "Get fruit by Id")
    public Fruit get(
            @ShellOption String id
    ) {
        return this.fruitService.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit %s not found".formatted(id)));
    }

    @ShellMethod(key = "fruit add", value = "Add Fruit")
    public void add(
            @ShellOption String id,
            @ShellOption String name
    ) {
        this.fruitService.create(new Fruit(id, name));
    }

    @ShellMethod(key = "fruit update", value = "Update Fruit")
    public void update(
            @ShellOption String id,
            @ShellOption String name
    ) {

        this.get(id);

        this.fruitService.update(new Fruit(id, name));
    }

    @ShellMethod(key = "fruit delete", value = "Delete Fruit")
    public void delete(
            @ShellOption String id
    ) {

        this.get(id);

        this.fruitService.delete(id);
    }

    @ExceptionResolver
    @ExitCode(code = 5)
    private String errorHandler(FruitNotFoundException e) {
        return e.getMessage();
    }
}
