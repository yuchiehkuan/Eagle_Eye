package com.example.eagle_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText account = findViewById(R.id.account);
        EditText password = findViewById(R.id.pwd);
        Button register = (Button)findViewById(R.id.action_register);
        Button login = (Button)findViewById(R.id.action_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (account.getText().toString().isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "未輸入帳號", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "未輸入密碼", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://10.0.2.2:5000/api/login";/*在此處改變你的伺服器地址*/
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", account.getText().toString() );
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
                                intent.setClass(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}