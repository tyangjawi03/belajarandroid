package id.tyangjawi03.belajarandroid;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by macbookair on 7/10/17.
 */

public class MyFirstTask extends AsyncTask<Void, Void, Void> {

    private String TAG = "MyFirstTask";

    @Override
    protected Void doInBackground(Void... params) {
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.e(TAG, "Prosess dalam thread berbeda " + (i + 1));
        }

        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
