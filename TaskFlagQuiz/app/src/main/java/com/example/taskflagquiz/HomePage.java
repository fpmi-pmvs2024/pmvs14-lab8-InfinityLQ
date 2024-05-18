package com.example.taskflagquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class HomePage extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        uname = findViewById(R.id.txtName);
        pwd = findViewById(R.id.txtPwd);
        loginBtn = findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();

                if (username.equals("game") && password.equals("011024")) {
                    Intent intent = new Intent(HomePage.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credentials are not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

