package newton.mathmania.models;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import newton.mathmania.ChooseDifficultyActivity;

public class JsonParse {

    private ArrayList<question> questionList = new ArrayList<>();
    int x = ChooseDifficultyActivity.multiplicationTableChoice;

    public String loadJSONFromAsset(Context myContext)
    {
        String json = null;
        try
        {
            InputStream is = myContext.getAssets().open("json/multiplicationTable" + x + ".json");

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
                int answer = jsonArray.getJSONObject(i).getInt("answer");
                int decoy1 = jsonArray.getJSONObject(i).getInt("decoy1");
                int decoy2 = jsonArray.getJSONObject(i).getInt("decoy2");
                int decoy3 = jsonArray.getJSONObject(i).getInt("decoy3");
                int decoy4 = jsonArray.getJSONObject(i).getInt("decoy4");
                int decoy5 = jsonArray.getJSONObject(i).getInt("decoy5");

                questionList.add(new question(question, answer, decoy1, decoy2, decoy3, decoy4, decoy5));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
