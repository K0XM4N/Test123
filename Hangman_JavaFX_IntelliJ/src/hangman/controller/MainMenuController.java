package hangman.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import hangman.model.PlayerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Krzysztof
 */
public class MainMenuController{
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btnSinglePlayer, btnQuit;;

    private GameController gameController;



    @FXML
    private void handleSinglePlayerBtn(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/singleplayer_input_page_view.fxml"));
        Pane pane = loader.load();
        gameController.setScreen(pane);

        SingleplayerInputPageController singleplayerInputPageController = loader.getController();
        singleplayerInputPageController.setMainMenuController(gameController);

    }


    @FXML
    private void handleTwoPlayersBtn(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/twoplayers_input_page_view.fxml"));
        Pane pane = loader.load();
        gameController.setScreen(pane);

        TwoPlayersInputPageController twoPlayersInputPageController = loader.getController();
        twoPlayersInputPageController.setGameController(gameController);

    }

    @FXML
    private void handleQuitBtn(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
