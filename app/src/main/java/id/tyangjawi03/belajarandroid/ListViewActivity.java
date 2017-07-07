package id.tyangjawi03.belajarandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private String TAG = "ListViewActivity";

    private ListView listView;

    private String[] data = {
            "Data Dummy 1",
            "Data Dummy 2",
            "Data Dummy 3",
            "Data Dummy 4",
            "Data Dummy 5",
            "Data Dummy 6",
            "Data Dummy 7",
            "Data Dummy 8",
            "Data Dummy 9",
            "Data Dummy 10",
            "Data Dummy 11",
            "Data Dummy 12",
            "Data Dummy 13",
            "Data Dummy 14",
            "Data Dummy 15"
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, ListViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        listView.setAdapter(arrayAdapter);
    }

}
