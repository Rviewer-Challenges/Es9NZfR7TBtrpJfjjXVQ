package com.example.MemoryBackend.model;

public class Game {
    private int difficulty; // 1 for Easy, 2 for Medium, 3 for Difficult
    private int[][] board;
    private int moves;
    private int timeLeft;
    private int pairsRemaining;

    public Game() {
    }
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getPairsRemaining() {
        return pairsRemaining;
    }

    public void setPairsRemaining(int pairsRemaining) {
        this.pairsRemaining = pairsRemaining;
    }
}
