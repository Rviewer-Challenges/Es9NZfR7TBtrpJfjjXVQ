package com.example.MemoryBackend.service;

import com.example.MemoryBackend.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private static final int[] EASY_DIMENSIONS = {4, 4};
    private static final int[] MEDIUM_DIMENSIONS = {4, 6};
    private static final int[] DIFFICULT_DIMENSIONS = {5, 6};
    private static final int[] CARD_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public Game createGame(int difficulty) {
        List<Integer> cards = generateCards(difficulty);
        Game game = new Game();
        game.setDifficulty(difficulty);
        game.setBoard(generateBoard(difficulty, cards));
        game.setMoves(0);
        game.setTimeLeft(60);
        game.setPairsRemaining(cards.size() / 2);
        return game;
    }

    private List<Integer> generateCards(int difficulty) {
        int numPairs = getDimensions(difficulty)[0] * getDimensions(difficulty)[1] / 2;
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < numPairs; i++) {
            for (int j = 0; j < 2; j++) {
                cards.add(CARD_VALUES[i]);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    private int[][] generateBoard(int difficulty, List<Integer> cards) {
        int[] dimensions = getDimensions(difficulty);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] board = new int[rows][cols];
        int cardIndex = 0;

        // Fill the board with cards
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = cards.get(cardIndex++);
            }
        }

        return board;
    }

    private int[] getDimensions(int difficulty) {
        switch (difficulty) {
            case 1:
                return EASY_DIMENSIONS;
            case 2:
                return MEDIUM_DIMENSIONS;
            case 3:
                return DIFFICULT_DIMENSIONS;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }
    }


}
