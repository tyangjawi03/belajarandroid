package id.tyangjawi03.belajarandroid;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by macbookair on 7/7/17.
 */

public class CustomAdapter extends ArrayAdapter<String[]> {

    private Context mContext;
    private String[][] mValues;

    public CustomAdapter(@NonNull Context context, String[][] values) {
        super(context, -1, values);
        mContext = context;
        mValues = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.adapter_custom, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView subTitle = (TextView) rowView.findViewById(R.id.sub_title);

        title.setText(mValues[position][0]);
        subTitle.setText(mValues[position][1]);

        return rowView;
    }
    
}
