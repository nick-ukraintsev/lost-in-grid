package com.example.lostingrid.entity;

public enum MazeAlgorithm {
    DFS("Dfs"),
    PRIM("Prim"),
    KRUSKAL("Kruskal"),;

    private final String label;

    MazeAlgorithm(String label) {
        this.label = label;
    }
}
