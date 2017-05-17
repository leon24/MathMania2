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

        parseJson(loadJSONFromAsset());
    }

    public String loadJSONFromAsset()
    {
        String json = null;
        try
        {
            InputStream is = getAssets().open("JSON.json");

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
            JSONArray jsonArray = jsonObject.getJSONArray("answers");

            for (int i = 0; i < jsonArray.length(); i++)
            {
                String answer = jsonArray.getJSONObject(i).getString("answer");
                Log.i("Tag", "answer: " + answer);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}