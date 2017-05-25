package newton.mathmania.models;


import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import newton.mathmania.ChooseDifficultyActivity;
import newton.mathmania.EasyDifficultyActivity;
import newton.mathmania.HardDifficultyActivity;
import newton.mathmania.ResultActivity;


public class ViewModel extends BaseObservable {

    public static ArrayList<Answer> answerList = new ArrayList<>();
    public static ArrayList<question> questionList = new ArrayList<>();

    private String question;
    private int answer;
    private int decoy1;
    private int decoy2;
    private int decoy3;
    private int decoy4;
    private int decoy5;
    private int counter = 0;
    public static int points = 0;
    private String countDown;
    private HardDifficultyActivity hard = new HardDifficultyActivity();
    private ArrayList<Integer> IntList = new ArrayList<>();
    private JsonParse Json = new JsonParse();
    private Context context;
    private boolean difficulty = ChooseDifficultyActivity.radioButtonDifficulty;

    public ViewModel(Context context){
        this.context = context;
    }



    public void setCountDown(String countDown){
        this.countDown = countDown;
        notifyPropertyChanged(newton.mathmania.BR.countDown);
    }

    public void setQuestion(String question) {
        this.question = question;
        notifyPropertyChanged(newton.mathmania.BR.question);
    }

    public void setAnswer(int answer) {
        this.answer = answer;
        notifyPropertyChanged(newton.mathmania.BR.answer);
    }

    public void setDecoy1(int decoy1) {
        this.decoy1 = decoy1;
        notifyPropertyChanged(newton.mathmania.BR.decoy1);
    }

    public void setDecoy2(int decoy2) {
        this.decoy2 = decoy2;
        notifyPropertyChanged(newton.mathmania.BR.decoy2);
    }

    public void setDecoy3(int decoy3) {
        this.decoy3 = decoy3;
        notifyPropertyChanged(newton.mathmania.BR.decoy3);
    }

    public void setDecoy4(int decoy4) {
        this.decoy4 = decoy4;
        notifyPropertyChanged(newton.mathmania.BR.decoy4);
    }

    public void setDecoy5(int decoy5) {
        this.decoy5 = decoy5;
        notifyPropertyChanged(newton.mathmania.BR.decoy5);
    }


    @Bindable
    public String getCountDown(){return countDown;}
    @Bindable
    public String getQuestion() {
        return question;
    }
    @Bindable
    public int getAnswer() {
        return answer;
    }
    @Bindable
    public int getDecoy1() {
        return decoy1;
    }
    @Bindable
    public int getDecoy2() {
        return decoy2;
    }
    @Bindable
    public int getDecoy3() {
        return decoy3;
    }
    @Bindable
    public int getDecoy4() {
        return decoy4;
    }
    @Bindable
    public int getDecoy5() {
        return decoy5;
    }

    public void StartButtonPressed (){
        String j = Json.loadJSONFromAsset(context);
        Json.parseJson(j, questionList);
        Collections.shuffle(questionList);
        setNewQuestion();
    }

   public CountDownTimer easyCountdown = new CountDownTimer(21000, 1000) {

        public void onTick(long millisUntilFinished) {
            setCountDown(""+millisUntilFinished / 1000);
        }

        public void onFinish() {
            counter++;
            setNewQuestion();
        }
    };

    public CountDownTimer hardCountdown = new CountDownTimer(11000, 1000) {

        public void onTick(long millisUntilFinished) {
            setCountDown(""+millisUntilFinished / 1000);
        }

        public void onFinish() {
            counter++;
            setNewQuestion();
        }
    };

    public void setNewQuestion(){
        IntList.clear();
        if (difficulty) {
            easyCountdown.start();
            IntList.add(0, questionList.get(counter).getAnswer());
            IntList.add(1, questionList.get(counter).getDecoy1());
            IntList.add(2, questionList.get(counter).getDecoy2());
            IntList.add(3, questionList.get(counter).getDecoy3());
            Collections.shuffle(IntList);
            setQuestion(questionList.get(counter).getQuestion());
            setAnswer(IntList.get(0));
            setDecoy1(IntList.get(1));
            setDecoy2(IntList.get(2));
            setDecoy3(IntList.get(3));
        }
        else {
            hardCountdown.start();
            IntList.add(0, questionList.get(counter).getAnswer());
            IntList.add(1, questionList.get(counter).getDecoy1());
            IntList.add(2, questionList.get(counter).getDecoy2());
            IntList.add(3, questionList.get(counter).getDecoy3());
            IntList.add(4, questionList.get(counter).getDecoy4());
            IntList.add(5, questionList.get(counter).getDecoy5());
            Collections.shuffle(IntList);
            setQuestion(questionList.get(counter).getQuestion());
            setAnswer(IntList.get(0));
            setDecoy1(IntList.get(1));
            setDecoy2(IntList.get(2));
            setDecoy3(IntList.get(3));
            setDecoy4(IntList.get(4));
            setDecoy5(IntList.get(5));

        }
    }


    public void buttonPressed1(View v){
        hardCountdown.cancel();
        easyCountdown.cancel();
        if(answer == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:","" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), answer));
        counter++;
        if(counter == 10) {
            startResultActivity(v);
        }
        else{setNewQuestion();}
    }

    public void buttonPressed2(View v){
        hardCountdown.cancel();
        easyCountdown.cancel();
        if(decoy1 == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:","" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), decoy1));
        counter++;
        if(counter == 10) {
            startResultActivity(v);
        }
        else{setNewQuestion();}
    }

    public void buttonPressed3(View v){
        hardCountdown.cancel();
        easyCountdown.cancel();
        if(decoy2 == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:", "" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), decoy2));
            counter++;
            if(counter == 10) {
                startResultActivity(v);
            }
            else{setNewQuestion();}
    }
    public void buttonPressed4(View v){
        hardCountdown.cancel();
        easyCountdown.cancel();
        if(decoy3 == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:", "" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), decoy3));
            counter++;
            if(counter == 10) {
                startResultActivity(v);
            }
            else{setNewQuestion();}
    }
    public void buttonPressed5(View v){
        hardCountdown.cancel();
        if(decoy4 == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:", "" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), decoy4));
        counter++;
            if(counter == 10) {
                startResultActivity(v);
            }
            else{setNewQuestion();}
    }
    public void buttonPressed6(View v){
        hardCountdown.cancel();
        if(decoy5 == questionList.get(counter).getAnswer()) {
            points++;
            Log.i("POINTS:","" + points);
        }

        answerList.add(new Answer(questionList.get(counter).getQuestion(), questionList.get(counter).getAnswer(), decoy5));

        counter++;
        if(counter == 10) {
            startResultActivity(v);
        }
        else{setNewQuestion();}
    }
    public void startResultActivity(View v){
        Intent intent = new Intent(v.getContext(), ResultActivity.class);
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("score", points);
        v.getContext().startActivity(intent);
    }
}
