package me.nzuguem.spring_boot_shell_tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;


@ShellTest(useDefaultFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseCommandTests {

    @Autowired
    protected ShellTestClient client;
}
