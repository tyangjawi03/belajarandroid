package id.tyangjawi03.belajarandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegiterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private EditText passwordLagi;
    private Button   register;

    private SharedPreferences credential;

    public static void start(Context context) {
        Intent starter = new Intent(context, RegiterActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        passwordLagi = (EditText) findViewById(R.id.input_password_lagi);

        register = (Button) findViewById(R.id.button_register);
        register.setOnClickListener(this);

        credential = this.getSharedPreferences("nama_file_share_preference", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(username.getText().toString())) {
            Toast.makeText(this, "Username cannot fill empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(this, "Password cannot fill empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(passwordLagi.getText().toString())) {
            Toast.makeText(this, "Password Lagi cannot fill empty", Toast.LENGTH_SHORT).show();
        }

        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        String passwordLagiText = passwordLagi.getText().toString();

        if (!passwordText.equals(passwordLagiText)) {
            Toast.makeText(this, "Password and Password Lagi do not match", Toast.LENGTH_SHORT).show();
        }

        SharedPreferences.Editor credentialEditor = credential.edit();
        credentialEditor.putString("USERNAME", usernameText);
        credentialEditor.putString("PASSWORD", passwordText);
        credentialEditor.apply();

        Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();

        MainActivity.start(this);
        finish();
    }

}
