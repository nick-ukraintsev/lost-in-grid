package com.example.lostingrid.service;

import com.example.lostingrid.entity.Cell;
import com.example.lostingrid.entity.CellType;
import com.example.lostingrid.entity.Grid;
import com.example.lostingrid.entity.MazeAlgorithm;
import com.example.lostingrid.entity.MazeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MazeServiceImpl implements MazeService {

    private final int[][] directions = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};

    public MazeResponse generateMaze(int rows, int cols, MazeAlgorithm algorithmType) {
        if (rows % 2 == 0) rows++;
        if (cols % 2 == 0) cols++;

        Grid grid = new Grid(rows, cols);
        List<Cell> steps = new ArrayList<>();

        // Спочатку все - стіни
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid.setCell(r, c, CellType.WALL);
            }
        }

        Random random = new Random();
        dfs(1, 1, grid, steps, random);

        return new MazeResponse(grid, steps);
    }

    private void dfs(int r, int c, Grid grid, List<Cell> steps, Random rand) {
        grid.setCell(r, c, CellType.PATH);
        steps.add(new Cell(r, c, CellType.PATH));

        List<int[]> dirs = new ArrayList<>(Arrays.asList(directions));
        Collections.shuffle(dirs, rand);

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (isInBounds(nr, nc, grid) && grid.getCells()[nr][nc] == CellType.WALL) {
                int wallR = r + dir[0] / 2;
                int wallC = c + dir[1] / 2;

                grid.setCell(wallR, wallC, CellType.PATH);
                steps.add(new Cell(wallR, wallC, CellType.PATH));

                dfs(nr, nc, grid, steps, rand);
            }
        }
    }

    private boolean isInBounds(int r, int c, Grid grid) {
        return r > 0 && r < grid.getRows() && c > 0 && c < grid.getCols();
    }

    @Override
    public List<int[]> solveMaze(List<List<Integer>> maze) {
        // Заглушка: тут буде алгоритм пошуку шляху (наприклад, BFS або DFS)
        return new ArrayList<>();
    }
}
