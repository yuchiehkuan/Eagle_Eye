package com.example.eagle_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eagle_eye.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 略..
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 設置要用哪個menu檔做為選單
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_home:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity.class);
                this.startActivity(intent);
                return true;

            case R.id.action_maps:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, MapsActivity.class);
                this.startActivity(intent1);
                return true;

            case R.id.action_record:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, RecordActivity.class);
                this.startActivity(intent2);
                return true;

            case R.id.action_setting:
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this, SettingActivity.class);
                this.startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}