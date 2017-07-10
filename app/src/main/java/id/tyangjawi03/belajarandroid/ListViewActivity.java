package id.tyangjawi03.belajarandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private String TAG = "ListViewActivity";

    private ListView listView;

    private String[][] data = new String[20][2];

    private Intent service;

    public static void start(Context context) {
        Intent starter = new Intent(context, ListViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        service = new Intent(this, MyFirstService.class);
        isiArray();

        listView = (ListView) findViewById(R.id.list_view);

        CustomAdapter arrayAdapter = new CustomAdapter(this, data);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListViewActivity.this, data[position][0] + " " + data[position][1], Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void isiArray() {

        for (int i=0; i<20; i++) {
            data[i][0] = "Title " + (i+1);
            data[i][1] = "Data Dummy " + (i+1);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_satu :
                startService(service);
                break;
            case R.id.menu_dua :
                stopService(service);
                break;
        }

        return true;
    }

}
