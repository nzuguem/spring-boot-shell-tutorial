package me.nzuguem.spring_boot_shell_tutorial.services;


import me.nzuguem.spring_boot_shell_tutorial.utils.LoggerUtils;
import org.springframework.stereotype.Service;

@Service
public class HelloService {


    public String hello(String name) {

        LoggerUtils.log(name);

        return "Hello " + name + "!";
    }
}
