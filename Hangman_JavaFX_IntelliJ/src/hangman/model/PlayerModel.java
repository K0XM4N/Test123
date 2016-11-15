package hangman.model;

/**
 * Created by Krzysztof on 2016-10-19.
 */
public class PlayerModel {
    private String name;

    private int scores;
    private int totalScore;
    private int correctAnswers;
    private int incorrectAnswers;
    private int errorThreshold;

    public PlayerModel(String name){
        this.name = name;
        this.scores = 0;
        this.totalScore = 0;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }




    //-----------getters

    public String getName() {
        return name;
    }

    public int getScores() {
        return scores;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public int getErrorThreshold() {
        return errorThreshold;
    }



    //-----------setters

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setErrorThreshold(int errorThreshold) {
        this.errorThreshold = errorThreshold;
    }
}
