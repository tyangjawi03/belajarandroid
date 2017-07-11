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

import java.util.ArrayList;
import java.util.List;

import id.tyangjawi03.belajarandroid.model.MyData;

/**
 * Created by macbookair on 7/7/17.
 */

public class CustomAdapter extends ArrayAdapter<MyData> {

    private Context mContext;
    private List<MyData> mValues;

    public CustomAdapter(@NonNull Context context, List<MyData> values) {
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

        title.setText(mValues.get(position).getTitle());
        subTitle.setText(mValues.get(position).getSub_title());

        return rowView;
    }
    
}
