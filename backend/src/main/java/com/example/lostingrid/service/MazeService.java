package com.example.lostingrid.service;

import java.util.List;

public interface MazeService {

    List<List<Integer>> generateMaze(int rows, int cols);

    List<int[]> solveMaze(List<List<Integer>> maze);
}
