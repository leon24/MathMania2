package newton.mathmania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void playButtonClick(View v) {

        Intent intent = new Intent(MenuActivity.this, ChooseDifficultyActivity.class);
        MenuActivity.this.startActivity(intent);
    }

    public void logoutButtonClick(View v) {

        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        MenuActivity.this.startActivity(intent);

    }

    public void settingsButtonClick(View v) {

        toastMessage("Application settings.");
    }

    public void aboutButtonClick(View v) {

        Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
        MenuActivity.this.startActivity(intent);
    }

    private void toastMessage (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}