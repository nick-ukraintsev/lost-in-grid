package com.example.lostingrid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MazeResponse {
    private Grid grid;
    private List<Cell> steps;
}
