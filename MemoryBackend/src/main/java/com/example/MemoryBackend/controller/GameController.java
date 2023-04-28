package com.example.MemoryBackend.controller;

import com.example.MemoryBackend.model.Game;
import com.example.MemoryBackend.model.GameRequest;
import com.example.MemoryBackend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public Game createGame(@RequestParam int difficulty) {
        return gameService.createGame(difficulty);
    }

    @PostMapping("/game/move")
    public Game makeMove(@RequestBody GameRequest gameRequest) {
        Game game = gameRequest.getGame();
        int row1 = gameRequest.getRow1();
        int col1 = gameRequest.getCol1();
        int row2 = gameRequest.getRow2();
        int col2 = gameRequest.getCol2();
        String card1 = String.valueOf(game.getBoard()[row1][col1]);
        String card2 = String.valueOf(game.getBoard()[row2][col2]);
        // Check if the cards are the same
        if (game.getBoard()[row1][col1] == game.getBoard()[row2][col2]) {
            game.getBoard()[row1][col1] = -1;
            game.getBoard()[row2][col2] = -1;
            game.setPairsRemaining(game.getPairsRemaining() - 1);
        }

        // Increment the number of moves
        game.setMoves(game.getMoves() + 1);

        // Return the updated game
        return game;
    }

}

