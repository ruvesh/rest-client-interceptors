package io.github.ruvesh.restclientinterceptors.service.impl;

import io.github.ruvesh.restclientinterceptors.service.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TodoServiceImpl implements TodoService {

    private final RestClient client;

    public TodoServiceImpl(RestClient client) {
        this.client = client;
    }

    @Override
    public String findAllTodos() {
        return client.get()
                .uri("/todos")
                .retrieve()
                .body(String.class);
    }
}
