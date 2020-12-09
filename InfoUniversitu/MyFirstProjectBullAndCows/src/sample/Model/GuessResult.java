package sample.Model;

public class GuessResult {
    private String guess_num;
    private String guess_result;

    public GuessResult(String num, String result){
        this.guess_num = num;
        this.guess_result = result;
    }

    public String getGuess_num() {
        return guess_num;
    }

    public String getGuess_result() {
        return guess_result;
    }
}
