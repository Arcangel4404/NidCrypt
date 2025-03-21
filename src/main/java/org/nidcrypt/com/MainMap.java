package org.nidcrypt.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMap {
    private char[][] grid;
    private final int gridSize = 50; // 50 unique characters
    private final int gridWidth = 10;
    private final int gridHeight = 5;

    public MainMap() {
        generateRandomGrid();
    }

    private void generateRandomGrid() {
        List<Character> characters = new ArrayList<>();
        
        // Add A-Z
        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }

        // Add 24 unique gibberish characters
        String gibberish = "!@#$%^&*()_+{}[];:<>?|~`1234567890-=,./";
        for (char c : gibberish.toCharArray()) {
            if (characters.size() < gridSize) {
                characters.add(c);
            }
        }

        // Shuffle and assign to grid
        Collections.shuffle(characters);
        grid = new char[gridHeight][gridWidth];
        int index = 0;
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                grid[i][j] = characters.get(index++);
            }
        }
    }

    public void printGrid() {
        for (char[] row : grid) {
            for (char letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }

    public char getLetter(int row, int col) {
        return grid[row][col];
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int[] findLetterPosition(char letter) {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == letter) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
