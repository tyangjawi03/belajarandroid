package id.tyangjawi03.belajarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "On Create Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "On Start Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "On Restart Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "On Resume Activity");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.e(TAG, "On BackPressed Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "On Pause Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "On Stop Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "On Destroy Activity");
    }

}
