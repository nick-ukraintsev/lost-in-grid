package com.example.lostingrid.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MazeService {

    private final Random random = new Random();

    public List<List<Integer>> generateMaze(int rows, int cols) {
        List<List<Integer>> maze = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                // 0 — прохід, 1 — стіна
                int cell = (i == 0 && j == 0) || (i == rows - 1 && j == cols - 1)
                        ? 0 // старт і фініш завжди прохід
                        : random.nextInt(100) < 30 ? 0 : 1; // 70% ймовірність проходу
                row.add(cell);
            }
            maze.add(row);
        }

        return maze;
    }

    public List<int[]> solveMaze(List<List<Integer>> maze) {
        // Заглушка: тут буде алгоритм пошуку шляху (наприклад, BFS або DFS)
        return new ArrayList<>();
    }
}
