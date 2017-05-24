package newton.mathmania.models;


public class question {

    private String question;
    private int answer;

    public question(String question, int answer, int decoy1, int decoy2, int decoy3, int decoy4, int decoy5) {
        this.question = question;
        this.answer = answer;
        this.decoy1 = decoy1;
        this.decoy2 = decoy2;
        this.decoy3 = decoy3;
        this.decoy4 = decoy4;
        this.decoy5 = decoy5;
    }
    public question(String question, int answer, int decoy1, int decoy2, int decoy3){
        this.question = question;
        this.answer = answer;
        this.decoy1 = decoy1;
        this.decoy2 = decoy2;
        this.decoy3 = decoy3;
    }

    private int decoy1;
    private int decoy2;
    private int decoy3;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getDecoy1() {
        return decoy1;
    }

    public void setDecoy1(int decoy1) {
        this.decoy1 = decoy1;
    }

    public int getDecoy2() {
        return decoy2;
    }

    public void setDecoy2(int decoy2) {
        this.decoy2 = decoy2;
    }

    public int getDecoy3() {
        return decoy3;
    }

    public void setDecoy3(int decoy3) {
        this.decoy3 = decoy3;
    }

    public int getDecoy4() {
        return decoy4;
    }

    public void setDecoy4(int decoy4) {
        this.decoy4 = decoy4;
    }

    public int getDecoy5() {
        return decoy5;
    }

    public void setDecoy5(int decoy5) {
        this.decoy5 = decoy5;
    }

    private int decoy4;
    private int decoy5;


}
