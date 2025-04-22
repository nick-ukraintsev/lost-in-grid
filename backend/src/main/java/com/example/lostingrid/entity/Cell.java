package com.example.lostingrid.entity;

import lombok.Data;

@Data
public class Cell {
    private int row;
    private int col;
    private CellType type;

    public Cell(int row, int col, CellType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}