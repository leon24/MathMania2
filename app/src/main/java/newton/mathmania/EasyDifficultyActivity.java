package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

import newton.mathmania.databinding.ActivityEasyDifficultyBinding;
import newton.mathmania.databinding.ActivityHardDifficultyBinding;
import newton.mathmania.models.ViewModel;

public class EasyDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel();
        super.onCreate(savedInstanceState);
        ActivityEasyDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_easy_difficulty);
        binding.setViewModel(viewmodel);
        viewmodel.StartButtonPressed();

        parseJson(loadJSONFromAsset());
    }
    int x = ChooseDifficultyActivity.multiplicationTableChoice;
    boolean rbDif = ChooseDifficultyActivity.radioButtonDifficulty;

    public String loadJSONFromAsset()
    {
        String json = null;
        try
        {
            InputStream is = getAssets().open("json/multiplicationTable" + x + ".json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void parseJson(String json)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("multiplicationTable" + x);

            for (int i = 0; i < jsonArray.length(); i++)
            {
                String question = jsonArray.getJSONObject(i).getString("question" + (i + 1));
                String answer = jsonArray.getJSONObject(i).getString("answer");
                String decoy1 = jsonArray.getJSONObject(i).getString("decoy1");
                String decoy2 = jsonArray.getJSONObject(i).getString("decoy2");
                String decoy3 = jsonArray.getJSONObject(i).getString("decoy3");

                //if (rbDif == false)
                //{
                    String decoy4 = jsonArray.getJSONObject(i).getString("decoy4");
                    String decoy5 = jsonArray.getJSONObject(i).getString("decoy5");
                //}
                Log.i("Tag", "question: " + question);
                Log.i("Tag", "answer: " + answer);
                Log.i("Tag", "decoy1: " + decoy1);
                Log.i("Tag", "decoy2: " + decoy2);
                Log.i("Tag", "decoy3: " + decoy3);
                Log.i("Tag", "decoy4: " + decoy4);
                Log.i("Tag", "decoy5: " + decoy5);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}