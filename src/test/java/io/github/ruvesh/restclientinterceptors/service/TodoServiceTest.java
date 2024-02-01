package io.github.ruvesh.restclientinterceptors.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Test
    void findAllTodos() {
        String todos = todoService.findAllTodos();
        assertNotNull(todos);
    }
}