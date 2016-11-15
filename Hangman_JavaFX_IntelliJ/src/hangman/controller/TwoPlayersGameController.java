package hangman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2016-10-18.
 */
public class TwoPlayersGameController {

    private GameController gameController;

    @FXML
    public void handleLetterCheck(ActionEvent event) {

        String letter = ((Button) event.getSource()).getText();
        ((Button) event.getSource()).setDisable(true);
        System.out.println(letter);

        //METHODS THAT PERFMORM CHECK LETTER OPERATION IN RANDOMIZED WORD
        // GENERATING IMG ETC.
        //....
        //...
        // DISABLE LETTER AFTER CLICK

    }

    public void handleBackToMenuBtn(ActionEvent event) throws IOException {
        gameController.loadMenuScreen();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
