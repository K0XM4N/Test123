package hangman.controller;
import java.io.IOException;

import hangman.model.GuessWordModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.bind.Marshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzysztof
 */
public class SingleplayerInputPageController {
    @FXML
    private Button btnBack, btnPlay;
    @FXML
    private TextField txtInputPlayer;
    @FXML
    private GameController gameController;
    private MainMenuController mainMenuController;
    //private GuessWordModel guessWordModel;

    private String a;


    @FXML
    private void handlePlayBtn(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/singleplayer_game_view.fxml"));
        Pane pane = loader.load();
        gameController.setScreen(pane);

        SingleplayerGameController singleplayerGameController = loader.getController();
        singleplayerGameController.setGameController(gameController);

        gameController.createPlayer(txtInputPlayer.getText());
        gameController.randomizeWord();
        gameController.setDisplayWord();
        gameController.setInitialValues();
        gameController.setGuessLetters();

        singleplayerGameController.setLblWord(gameController.getDisplayWord());
        gameController.setSingleplayerGameController(singleplayerGameController);
    }

    public void setMainMenuController(GameController gameController) {
        this.gameController = gameController;
    }


    public void handleBackToMenuBtn(ActionEvent event) throws IOException {
        gameController.loadMenuScreen();
    }

}
