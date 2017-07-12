package id.tyangjawi03.belajarandroid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.SQLException;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import id.tyangjawi03.belajarandroid.model.MyData;
import id.tyangjawi03.belajarandroid.model.MyDataSource;

public class ListViewActivity extends AppCompatActivity {

    private String TAG = "ListViewActivity";

    private ListView listView;

    private String[][] data = new String[20][2];

    private Intent service;
    private MyDataSource myDataSource;
    private List<MyData> myData;
    private CustomAdapter arrayAdapter = null;

    public static void start(Context context) {
        Intent starter = new Intent(context, ListViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myDataSource = new MyDataSource(this);
        myDataSource.open();

        service = new Intent(this, MyFirstService.class);

        listView = (ListView) findViewById(R.id.list_view);

        if (myDataSource.index() != null) {
            arrayAdapter = new CustomAdapter(this, myDataSource.index());

            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(ListViewActivity.this, data[position][0] + " " + data[position][1], Toast.LENGTH_SHORT).show();

                }
            });
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
                ServiceConnection connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.e(TAG, "onServiceConnected");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.e(TAG, "onServiceDisconnected");
                    }
                };
                bindService(service, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.add_data :
                myDataSource.create("Add Data", "time : " + DateFormat.getInstance().format(new Date(System.currentTimeMillis())));
                break;
        }

        return true;
    }

}
