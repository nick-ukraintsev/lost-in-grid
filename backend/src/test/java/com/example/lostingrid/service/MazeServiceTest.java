package com.example.lostingrid.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MazeServiceTest {

    private final MazeService mazeService = new MazeService();

    @Test
    void testGenerateMazeSizeAndStartEnd() {
        int rows = 10;
        int cols = 15;

        List<List<Integer>> maze = mazeService.generateMaze(rows, cols);

        assertEquals(rows, maze.size(), "Maze should have correct number of rows");

        for (List<Integer> row : maze) {
            assertEquals(cols, row.size(), "Each row should have correct number of columns");
        }

        assertEquals(0, maze.getFirst().getFirst(), "Start cell (0,0) should be a passage (0)");
        assertEquals(0, maze.get(rows - 1).get(cols - 1), "End cell should be a passage (0)");
    }

    @Test
    void testSolveMazeEmptyResultForNow() {
        // Створюємо простий прохідний лабіринт
        List<List<Integer>> maze = List.of(
                List.of(0, 0, 0),
                List.of(1, 1, 0),
                List.of(0, 0, 0)
        );

        List<int[]> result = mazeService.solveMaze(maze);

        // Заглушка повертає порожній список
        assertNotNull(result, "Result should not be null");
        assertTrue(result.isEmpty(), "Currently solveMaze should return empty path");
    }
}