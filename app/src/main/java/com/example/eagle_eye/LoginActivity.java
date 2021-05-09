package com.example.eagle_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText account = findViewById(R.id.account);
        EditText password = findViewById(R.id.pwd);
//        Button register = (Button)findViewById(R.id.action_register);
        Button login = (Button)findViewById(R.id.action_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (account.getText().toString().isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "未輸入帳號", Toast.LENGTH_SHORT).show();
//                } else if (password.getText().toString().isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "未輸入密碼", Toast.LENGTH_SHORT).show();
//                } else {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
//                }
            }
        });

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}