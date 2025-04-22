package com.example.lostingrid.controller;

import com.example.lostingrid.entity.MazeAlgorithm;
import com.example.lostingrid.entity.MazeResponse;
import com.example.lostingrid.service.MazeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maze")
public class MazeController {

    private final MazeService mazeService;

    public MazeController(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @GetMapping("/generate")
    public MazeResponse generateMaze(
            @RequestParam(defaultValue = "10") int rows,
            @RequestParam(defaultValue = "10") int cols,
            @RequestParam(defaultValue = "DFS") MazeAlgorithm algorithmType
    ) {
        return mazeService.generateMaze(rows, cols, algorithmType);
    }

    @PostMapping("/solve")
    public List<int[]> solveMaze(@RequestBody List<List<Integer>> maze) {
        return mazeService.solveMaze(maze);
    }
}
