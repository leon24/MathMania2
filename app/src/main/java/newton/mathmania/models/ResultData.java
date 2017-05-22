package newton.mathmania.models;

public class ResultData {

    private String question;
    private int answer;
    private boolean userAnswer;



    public ResultData(String question, int answer, boolean userAnswer) {
        this.question = question;
        this.answer = answer;
        this.userAnswer = userAnswer;
    }

}
