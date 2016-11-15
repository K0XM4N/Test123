package hangman.controller;

import hangman.model.GuessWordModel;
import hangman.model.PlayerModel;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.IOException;


/**
 * Created by Krzysztof on 2016-10-19.
 */
public class GameController {

    private PlayerModel player;
    private GuessWordModel guessWordModel;
    private SingleplayerGameController singleplayerGameController;

    @FXML
    private StackPane container;

    @FXML public void initialize() throws IOException {
        loadMenuScreen();
        guessWordModel = new GuessWordModel();
    }



    //----------------------setters

    public void setScreen(Pane pane) {
        container.getChildren().clear();
        container.getChildren().addAll(pane);
    }

    public void setDisplayWord(){
        guessWordModel.setDisplayWord();
    }

    public void setSingleplayerGameController(SingleplayerGameController singleplayerGameController) {
        this.singleplayerGameController = singleplayerGameController;
        this.guessWordModel.setSingleplayerGameController(singleplayerGameController);
    }

    public void setInitialValues(){
        this.player.setErrorThreshold(10);
        this.player.setScores(0);
        this.player.setCorrectAnswers(0);
        this.player.setIncorrectAnswers(0);
        guessWordModel.setGameController(this);
    }

    public void setGuessLetters(){
        guessWordModel.setGuessLetters();
    }

    public void setLetter(String letter){
        guessWordModel.setLetter(letter);
    }
    //---------------------getters

    public String getWord(){
        return guessWordModel.getWord();
    }

    public GuessWordModel getGuessWordModel() {
        return guessWordModel;
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public String getDisplayWord(){
        return guessWordModel.getDisplayWord().toString().replaceAll("\\[","").replaceAll(",","").replaceAll("\\]","");
    }

    public SingleplayerGameController getSingleplayerGameController() {
        return singleplayerGameController;
    }




    public void loadMenuScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/main_menu_view.fxml"));
        Pane pane = loader.load();
        setScreen(pane);

        MainMenuController mainMenuController = loader.getController();
        mainMenuController.setGameController(this);
    }

    public void createPlayer(String name){
        player = new PlayerModel(name);
        guessWordModel.setPlayer(player);
        System.out.println(player.getName());
    }

    public void randomizeWord(){
        guessWordModel.setWordBank(guessWordModel.loadWordFromTxt());
        guessWordModel.randomWord();;
    }

    public void letterCheck() throws InterruptedException, IOException {
        guessWordModel.checkLetterInWord();
    }

    public void resetPlayerValues(){
        player.setCorrectAnswers(0);
        player.setIncorrectAnswers(0);
        player.setErrorThreshold(10);
        player.setScores(0);
    }

}
