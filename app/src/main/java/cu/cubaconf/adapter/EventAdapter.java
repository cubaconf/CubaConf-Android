package cu.cubaconf.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cu.cubaconf.R;
import cu.cubaconf.model.Event;

/**
 * Created by akiel on 11/2/17.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private final Context context;
    private final Event[] values;
    private int mLastPosition;

    public EventAdapter(Context context, Event[] values) {
        super(context, R.layout.submission_item_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.event_item_layout, parent, false);

        TextView author = (TextView) rowView.findViewById(R.id.textViewAuthor);
        TextView title = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView time = (TextView) rowView.findViewById(R.id.textViewTime);

        author.setText(values[position].getAuthor());
        title.setText(values[position].getTitle());
        time.setText(values[position].getTime());

        if (position % 2 == 1) {
            rowView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        } else {
            rowView.setBackgroundColor(Color.WHITE);
        }

        return rowView;
    }
}
