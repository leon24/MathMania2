package newton.mathmania.models;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import newton.mathmania.R;

public class ResultListAdapter extends ArrayAdapter<Answer> {

    private ArrayList<Answer> dataSet;

    // View lookup cache
    private static class ViewHolder {
        TextView question;
        TextView correctAnswer;
        TextView chosenAnswer;
        ImageView grade;
    }

    public ResultListAdapter(ArrayList<Answer> data, Context context) {
        super(context, R.layout.listview_listitem, data);
        this.dataSet = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Answer answer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_listitem, parent, false);
            viewHolder.question = (TextView) convertView.findViewById(R.id.question_listItem);
            viewHolder.correctAnswer = (TextView) convertView.findViewById(R.id.correctAnswer_listItem);
            viewHolder.chosenAnswer = (TextView) convertView.findViewById(R.id.chosenAnswer_listItem);
            viewHolder.grade = (ImageView) convertView.findViewById(R.id.grade_listItem);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert answer != null;
        viewHolder.question.setText(answer.getQuestion());
        viewHolder.correctAnswer.setText(Integer.toString(answer.getCorrectAnswer()));
        viewHolder.chosenAnswer.setText(Integer.toString(answer.getChosenAnswer()));

        if (answer.getCorrectAnswer() == answer.getChosenAnswer()) {
            viewHolder.grade.setBackgroundResource(R.drawable.green_tick);
            viewHolder.grade.setContentDescription("You were right! Congratulations!");
            viewHolder.chosenAnswer.setTextColor(Color.GREEN);
        } else {
            viewHolder.grade.setBackgroundResource(R.drawable.red_cross);
            viewHolder.grade.setContentDescription("You were wrong, try again!");
            viewHolder.chosenAnswer.setTextColor(Color.RED);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}