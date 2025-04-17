package com.example.lostingrid.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MazeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getMazeTest() {

        String response = restTemplate.getForObject(getBaseUrl() + "/generate", String.class);
        assertNotNull(response);
    }

    @Test
    void solveMazeTest() {
        String response = restTemplate.postForObject(getBaseUrl() + "/solve", new ArrayList<>(), String.class);
        assertNotNull(response);
    }

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/maze";
    }
}