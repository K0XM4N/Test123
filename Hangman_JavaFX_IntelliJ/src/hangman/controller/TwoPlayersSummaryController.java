package hangman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2016-10-18.
 */
public class TwoPlayersSummaryController {
    @FXML
    public void handleContiunueGame(ActionEvent event) {
    }

    @FXML
    public void handleBackToMenu(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("view/main_menu_view.fxml"));
        Scene mainMenuScene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }
}
