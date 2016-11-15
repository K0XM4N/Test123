package hangman.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzysztof
 */
public class SingleplayerGameController extends Controller {
    @FXML
    private Button btnGameBackToMenu;
    @FXML
    private Label lblWord;
    @FXML
    private ImageView imgViewPicture;
    private int i;
    private GameController gameController;

    public void initialize(){
        imgViewPicture.setImage(new Image("hangman/view/images/0.PNG"));
        int i=0;
    }



    @FXML
    public void handleLetterCheck(ActionEvent event) throws InterruptedException, IOException {
        String letter = ((Button) event.getSource()).getText();
        ((Button) event.getSource()).setDisable(true);
        System.out.println(letter);
        gameController.setLetter(letter);
        gameController.letterCheck();

        //gameController.getWord();
        //METHODS THAT PERFMORM CHECK LETTER OPERATION IN RANDOMIZED WORD
        // GENERATING IMG ETC.
        //....
        //...
        // DISABLE LETTER AFTER CLICK
    }

    @Override
    public void handleBackToMenuBtn(ActionEvent event) throws IOException {
        gameController.loadMenuScreen();
        //METHODS THAT RESET ALL VALUES: RANDOMIZED WORD, SCORES ETC.
    }


    public void setLblWord(String displayWord) {
        System.out.println(displayWord);
        lblWord.setText(displayWord);
//        this.lblWord.setText(Integer.toString(i));
//        i++;
//        System.out.println(i);
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setImgViewPicture(String pictureNumber){
        imgViewPicture.setImage(new Image("hangman/view/images/"+pictureNumber+".PNG"));
    }
}
