package com.example.lostingrid.entity;


import lombok.Data;

@Data
public class Grid {
    private int rows;
    private int cols;
    private CellType[][] cells;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new CellType[rows][cols];
    }

    public void setCell(int row, int col, CellType type) {
        cells[row][col] = type;
    }
}
