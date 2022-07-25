package sg.edu.rp.c346.id21030068.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTask = rowView.findViewById(R.id.tvView);
        TextView tvDetails = rowView.findViewById(R.id.tvDate);

        ToDoItem currentVersion = versionList.get(position);

        tvTask.setText(currentVersion.getTitle());
        tvDetails.setText(currentVersion.toString());

        if (currentVersion.getDate().get(Calendar.YEAR) == 2021) {
            tvDetails.setTextColor(Color.RED);
        }

        return rowView;
    }
}