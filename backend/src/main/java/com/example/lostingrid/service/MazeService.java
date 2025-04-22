package com.example.lostingrid.service;

import com.example.lostingrid.entity.MazeAlgorithm;
import com.example.lostingrid.entity.MazeResponse;

import java.util.List;

public interface MazeService {

    MazeResponse generateMaze(int rows, int cols, MazeAlgorithm algorithmType);

    List<int[]> solveMaze(List<List<Integer>> maze);
}
