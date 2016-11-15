package hangman.model;

import hangman.controller.GameController;
import hangman.controller.SingleplayerGameController;
import hangman.controller.SingleplayerSummaryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof on 2016-10-19.
 */
public class GuessWordModel {
    private String word;
    private String letter;
    private char[] guessLetters;

    private List<String> wordBank;
    private List<String> displayWord;

    private PlayerModel player;
    private GameController gameController;
    private SingleplayerGameController singleplayerGameController;

    public GuessWordModel(){

    }

    //----------getters


    public String getWord() {
        return word;
    }

    public String getLetter() {
        return letter;
    }

    public List<String> getWordBank() {
        return wordBank;
    }

    public List<String> getDisplayWord() {
        return displayWord;
    }



    //----------setter

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setGuessLetters(){
        this.guessLetters = word.toCharArray();
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }

    public void setSingleplayerGameController(SingleplayerGameController singleplayerGameController) {
        this.singleplayerGameController = singleplayerGameController;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setWordBank(List<String> wordBank) {
        this.wordBank = wordBank;
    }

    public void setDisplayWord() {
        this.displayWord = new ArrayList<String>();
        for (int i=0; i < word.length();i++){
            this.displayWord.add("_ ");
        }
    }

    public void setLetterToDisplayWord(int index, String letter){
        this.displayWord.set(index, letter);
    }


    public void checkLetterInWord() throws InterruptedException, IOException {
        System.out.println("checkLetter");
        int correct = 0;
        int mistakes = 0;

            for (int i =0; i<guessLetters.length;i++){

                if (String.valueOf(letter).equals(String.valueOf(guessLetters[i]))){
                    correct++;
                    setLetterToDisplayWord(i, String.valueOf(guessLetters[i]));
                    guessLetters[i] = ' ';

                    player.setCorrectAnswers(player.getCorrectAnswers()+1);
                    player.setScores(player.getScores()+5);
                    player.setTotalScore(player.getTotalScore()+player.getScores());
                }
                else{
                    mistakes++;
                }
            }
        System.out.println(displayWord);
            singleplayerGameController.setLblWord(displayWord.toString().replaceAll("\\[","").replaceAll(",","").replaceAll("\\]",""));

            if (correct == 0){

                player.setErrorThreshold(player.getErrorThreshold()-1);
                player.setIncorrectAnswers(player.getIncorrectAnswers() + 1);
                player.setScores(player.getScores()-3);
                singleplayerGameController.setImgViewPicture(Integer.toString(player.getIncorrectAnswers()));

            }


            if ((player.getCorrectAnswers() == word.length()) || (player.getErrorThreshold() <=0)){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/singleplayer_summary_view.fxml"));
                Pane pane = loader.load();
                SingleplayerSummaryController singleplayerSummaryController = loader.getController();
                singleplayerSummaryController.setGameController(gameController);

                if (player.getCorrectAnswers() == word.length()){
                    singleplayerSummaryController.setLblWinText(player.getName().toUpperCase());
                }
                else{
                    singleplayerSummaryController.setLblLoseText(player.getName().toUpperCase());
                }
                singleplayerSummaryController.setSingleplayerGameController(singleplayerGameController);
                gameController.setScreen(pane);

            }
        }



    public List<String> loadWordFromTxt(){

        List<String> wordBank = new ArrayList<String>();

        File file = new File("src\\hangman\\model\\slownik.txt");
        FileReader fileReader;

        try {
            fileReader = new FileReader(file);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            while (reader.readLine() != null){
                String line = reader.readLine();
                String lineEdit = line.substring(0,line.length()-2).toUpperCase();
                wordBank.add(lineEdit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordBank;

    }

    public void randomWord(){

        List<String> wordList = getWordBank();
        int randomIndex = (int) (Math.random() * wordList.size()-1);

        word = wordList.get(randomIndex);

    }

}
