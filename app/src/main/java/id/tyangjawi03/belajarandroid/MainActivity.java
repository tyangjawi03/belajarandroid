package id.tyangjawi03.belajarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Main Activity";

    private TextView labelUsername;
    private TextView labelPassword;

    private EditText inputUsername;
    private EditText inputPassword;

    private Button   buttonLogin;

    private String   username;
    private String   password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "On Create Activity");

        labelUsername   = (TextView) findViewById(R.id.label_username);
        labelPassword   = (TextView) findViewById(R.id.label_password);

        inputUsername   = (EditText) findViewById(R.id.input_username);
        inputPassword   = (EditText) findViewById(R.id.input_password);

        buttonLogin     = (Button)   findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "On Login Button CLick Alternative");

                username = inputUsername.getText().toString();
                password = inputPassword.getText().toString();

                Log.e(TAG, "Username : " + username);
                Log.e(TAG, "Password : " + password);

            }
        });
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
