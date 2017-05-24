package newton.mathmania.models;

public class Answer {

    private String Question;
    private int chosenAnswer;

    public Answer(String Question, int chosenAnswer) {
        this.Question = Question;
        this.chosenAnswer = chosenAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public int getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(int chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}
