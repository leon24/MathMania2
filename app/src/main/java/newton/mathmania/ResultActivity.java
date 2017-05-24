package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import newton.mathmania.databinding.ActivityResultBinding;

import newton.mathmania.models.ViewModel;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel(this);
        super.onCreate(savedInstanceState);

        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setViewModel(viewmodel);

        TextView score = (TextView) findViewById(R.id.textView2);

        score.setText(ViewModel.points + "points!");

    }
}
