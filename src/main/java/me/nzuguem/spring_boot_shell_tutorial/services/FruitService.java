package me.nzuguem.spring_boot_shell_tutorial.services;

import me.nzuguem.spring_boot_shell_tutorial.models.Fruit;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    private final JdbcClient jdbcClient;

    public FruitService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Fruit> findAll() {
        return this.jdbcClient.sql("SELECT id,name FROM fruit")
                .query(Fruit.class)
                .list();
    }

    public Optional<Fruit> findById(String id) {
        return this.jdbcClient.sql("SELECT id,name FROM fruit WHERE id = :id")
                .param("id", id)
                .query(Fruit.class)
                .optional();
    }

    public void create(Fruit fruit) {
        this.jdbcClient.sql("INSERT INTO fruit(id,name) VALUES(?,?)")
                .params(List.of(fruit.id(), fruit.name()))
                .update();

    }

    public void update(Fruit fruit, String id) {
        this.jdbcClient.sql("UPDATE fruit SET name = ? WHERE id = ?")
                .params(List.of(fruit.name(), id))
                .update();

    }

    public void delete(String id) {
        this.jdbcClient.sql("DELETE FROM fruit WHERE id = :id")
                .param("id", id)
                .update();

    }
}
