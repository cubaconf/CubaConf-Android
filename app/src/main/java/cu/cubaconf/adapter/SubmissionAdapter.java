package cu.cubaconf.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cu.cubaconf.R;
import cu.cubaconf.model.Submission;

/**
 * Created by akiel on 8/21/17.
 */

public class SubmissionAdapter extends ArrayAdapter<Submission> {

    private final Context context;
    private final Submission[] values;
    private int mLastPosition;

    public SubmissionAdapter(Context context, Submission[] values) {
        super(context, R.layout.submission_item_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.submission_item_layout, parent, false);

        TextView author = (TextView) rowView.findViewById(R.id.textViewAuthor);
        TextView title = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView summary = (TextView) rowView.findViewById(R.id.textViewAbstract);

        author.setText(values[position].getName());
        title.setText(values[position].getTitle());
        summary.setText(values[position].getSummary());

        if (position % 2 == 1) {
            rowView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        } else {
            rowView.setBackgroundColor(Color.WHITE);
        }

        return rowView;
    }
}
