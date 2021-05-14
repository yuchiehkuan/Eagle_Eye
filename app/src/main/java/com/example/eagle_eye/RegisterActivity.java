package com.example.eagle_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    OkHttpClient okHttpClient = new OkHttpClient();

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
        RadioGroup role = findViewById(R.id.role);
        RadioButton roleChk = findViewById(role.getCheckedRadioButtonId());

        Button register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission_id = 0;
                if (roleChk.getText().toString() == "family") {
                    permission_id = 2;
                } else {
                    permission_id = 1;
                }
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
                    String url = "http://10.0.2.2:5000/api/regiter";/*在此處改變你的伺服器地址*/
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", account.getText().toString() );
                        jsonObject.put("name", lastName.getText().toString());
                        jsonObject.put("email", email.getText().toString());
                        jsonObject.put("mobile", phone.getText().toString());
                        jsonObject.put("permission_id", permission_id);
                        jsonObject.put("password", password.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    RequestBody body = RequestBody.create(JSON, jsonObject.toString());
                    Request request = new Request.Builder().url(url).post(body).build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                          Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_LONG).show();
                            Log.e("Error", "404");
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            if (response.body().string().equals("401") ) {
                                Log.i("error", response.body().toString());
                            } else {
                                Log.i("login", response.body().toString());
                                Intent intent = new Intent();
                                intent.setClass(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

    }
}