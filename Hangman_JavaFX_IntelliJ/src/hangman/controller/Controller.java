package hangman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2016-10-19.
 */
public abstract class Controller {

    private GameController gameController;
    public void handleBackToMenuBtn(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/main_menu_view.fxml"));
        Pane pane = loader.load();
        gameController.setScreen(pane);

    }
}
