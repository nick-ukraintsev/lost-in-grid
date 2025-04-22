package com.example.lostingrid.service;

import com.example.lostingrid.entity.CellType;
import com.example.lostingrid.entity.MazeAlgorithm;
import com.example.lostingrid.entity.MazeResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MazeServiceTest {

    private final MazeService mazeService = new MazeServiceImpl();

    @Test
    void testGenerateMazeSizeAndStartEnd() {
        int rows = 11;
        int cols = 15;

        MazeResponse maze = mazeService.generateMaze(rows, cols, MazeAlgorithm.DFS);

        assertEquals(rows, maze.getGrid().getRows(), "Maze should have correct number of rows");
        assertEquals(cols, maze.getGrid().getCols(), "Maze should have correct number of cols");

        assertEquals(CellType.PATH, maze.getGrid().getCells()[1][1], "Start cell (1,1) should be a passage");
        assertEquals(CellType.PATH, maze.getGrid().getCells()[rows - 2][cols - 2], "End cell should be a passage");
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