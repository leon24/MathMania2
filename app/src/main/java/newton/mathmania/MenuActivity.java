package newton.mathmania;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void playButtonClick(View v) {

        AlertDialog.Builder chooseDifficulty = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        chooseDifficulty.setView(inflater.inflate(R.layout.dialog_difficulty, null));

        chooseDifficulty.setTitle("Choose a difficulty setting:");

        chooseDifficulty.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        chooseDifficulty.create().show();
    }

    public void easyButtonClick(View v) {

        toastMessage("Play on the easy difficulty.");

    }

    public void hardButtonClick(View v) {

        toastMessage("Play on the hard difficulty.");

    }

    public void accountButtonClick(View v) {

        toastMessage("Account settings and statistics.");
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
