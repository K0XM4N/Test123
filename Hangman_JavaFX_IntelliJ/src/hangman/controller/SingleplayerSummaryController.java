package hangman.controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzysztof
 */
public class SingleplayerSummaryController{
    @FXML
    private Button btnYes, btnNo;
    @FXML
    private Label lblWinLoseText, lblWordSummary;
    @FXML

    private GameController gameController;
    private SingleplayerGameController singleplayerGameController;

    //-------------setters

    public void setLblWinText(String playerName) {
        this.lblWinLoseText.setText(playerName + ", YOU WON!");
    }

    public void setLblLoseText(String playerName) {
        this.lblWinLoseText.setText(playerName + ", YOU LOSE!");
        this.lblWordSummary.setText(gameController.getWord());
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setSingleplayerGameController(SingleplayerGameController singleplayerGameController) {
        this.singleplayerGameController = singleplayerGameController;
    }



    @FXML
    public void handleContiunueGame(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/singleplayer_game_view.fxml"));
        Pane pane = loader.load();

        gameController.randomizeWord();
        gameController.setDisplayWord();
        gameController.setInitialValues();
        gameController.setGuessLetters();
        gameController.resetPlayerValues();

        singleplayerGameController = loader.getController();
        singleplayerGameController.setLblWord(gameController.getDisplayWord());
        singleplayerGameController.setGameController(gameController);
        gameController.setScreen(pane);

    }


    public void handleBackToMenu(ActionEvent event) throws IOException {
        gameController.loadMenuScreen();
    }
}
