package hangman;

import hangman.controller.GameController;
import hangman.controller.SingleplayerGameController;
import hangman.controller.SingleplayerInputPageController;
import hangman.model.PlayerModel;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("view/container.fxml"));
//        Scene scene = new Scene(root);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("HANGMAN");
//        primaryStage.show();

        StackPane stackPane = FXMLLoader.load(getClass().getResource("view/container.fxml"));
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HANGMAN");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        //SingleplayerGameController spGameController = new SingleplayerGameController();



        launch(args);
    }
}
