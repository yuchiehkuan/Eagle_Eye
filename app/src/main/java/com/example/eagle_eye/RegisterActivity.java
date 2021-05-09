package com.example.eagle_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText account = findViewById(R.id.account_register_edit);
        EditText password = findViewById(R.id.pwd_register_edit);
        EditText lastName = findViewById(R.id.lastname_register_edit);
        EditText firstName = findViewById(R.id.firstname_register_edit);
        EditText phone = findViewById(R.id.phone_register_edit);
        EditText email = findViewById(R.id.email_register_edit);

        Button register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (account.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入帳號", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入密碼", Toast.LENGTH_SHORT).show();
                } else if (lastName.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入名字", Toast.LENGTH_SHORT).show();
                } else if (firstName.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入姓氏", Toast.LENGTH_SHORT).show();
                } else if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入連絡電話", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "未輸入Email", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}