package newton.mathmania.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import newton.mathmania.R;

public class ResultListAdapter extends ArrayAdapter<Answer> {

    private ArrayList<Answer> dataSet;
    private Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView question;
        TextView correctAnswer;
        TextView chosenAnswer;
    }

    public ResultListAdapter(ArrayList<Answer> data, Context context) {
        super(context, R.layout.listitem_resultlist, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Answer answer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitem_resultlist, parent, false);
            viewHolder.question = (TextView) convertView.findViewById(R.id.question_listitem);
            viewHolder.correctAnswer = (TextView) convertView.findViewById(R.id.correctAnswer_listitem);
            viewHolder.chosenAnswer = (TextView) convertView.findViewById(R.id.chosenAnswer_listitem);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert answer != null;
        viewHolder.question.setText(answer.getQuestion());
        viewHolder.correctAnswer.setText(Integer.toString(answer.getCorrectAnswer()));
        viewHolder.chosenAnswer.setText(Integer.toString(answer.getChosenAnswer()));

        // Return the completed view to render on screen
        return convertView;
    }
}