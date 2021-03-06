package hangman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2016-10-18.
 */
public class TwoPlayersWordInputController extends Controller {

    private GameController gameController;

    @FXML
    public void handlePlayBtn(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/twoplayers_game_view.fxml"));
        Pane pane = loader.load();
        gameController.setScreen(pane);

        TwoPlayersGameController twoPlayersGameController = loader.getController();
        twoPlayersGameController.setGameController(gameController);
    }

    @Override
    public void handleBackToMenuBtn(ActionEvent event) throws IOException {
        gameController.loadMenuScreen();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
