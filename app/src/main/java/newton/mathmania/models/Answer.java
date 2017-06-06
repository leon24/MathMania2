package newton.mathmania.models;

public class Answer {

    private String Question;
    private int CorrectAnswer;
    private int ChosenAnswer;

    public Answer(String Question, int CorrectAnswer, int ChosenAnswer) {
        this.Question = Question;
        this.CorrectAnswer = CorrectAnswer;
        this.ChosenAnswer = ChosenAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public int getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(int CorrectAnswer) {
        this.CorrectAnswer = CorrectAnswer;
    }

    public int getChosenAnswer() {
        return ChosenAnswer;
    }

    public void setChosenAnswer(int ChosenAnswer) {
        this.ChosenAnswer = ChosenAnswer;
    }
}