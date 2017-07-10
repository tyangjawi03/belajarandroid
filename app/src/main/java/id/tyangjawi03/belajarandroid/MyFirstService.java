package id.tyangjawi03.belajarandroid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyFirstService extends Service {

    private String TAG = " MyFirstService";

    private MyFirstTask myFirstTask;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");

        Log.e(TAG, "Proses dalam thread utama 1");

        myFirstTask = new MyFirstTask();
        myFirstTask.execute();

        Log.e(TAG, "Proses dalam thread utama 2");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");

        Log.e(TAG, "Proses dalam thread utama 1");

        myFirstTask = new MyFirstTask();
        myFirstTask.execute();

        Log.e(TAG, "Proses dalam thread utama 2");

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG, "onRebind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");

        myFirstTask.cancel(true);
        myFirstTask = null;
    }

}
