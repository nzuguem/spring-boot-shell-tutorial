package me.nzuguem.spring_boot_shell_tutorial.configurations;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.MountableFile;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {

    @Bean
    @ServiceConnection("postgres")
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>("postgres:15.6-alpine")
                .withDatabaseName("fruits")
                .withUsername("fruit")
                .withPassword("fruit")
                // Those containers won't stop after all tests are finished.
                // https://java.testcontainers.org/features/reuse/
                .withReuse(true)
                .withCopyFileToContainer(
                        MountableFile.forClasspathResource("schema.sql"),
                        "/docker-entrypoint-initdb.d/schema.sql"
                );
    }
}
