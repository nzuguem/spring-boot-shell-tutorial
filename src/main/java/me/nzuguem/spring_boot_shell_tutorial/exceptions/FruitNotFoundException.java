package me.nzuguem.spring_boot_shell_tutorial.exceptions;

public class FruitNotFoundException extends RuntimeException {

    public FruitNotFoundException(String message) {
        super(message);
    }
}
