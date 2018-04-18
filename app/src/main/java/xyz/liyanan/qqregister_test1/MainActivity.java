package xyz.liyanan.qqregister_test1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    protected void checkLaunch(View view) {
        TextView tx1 = (TextView) findViewById(R.id.username);
        String str1 = tx1.getText().toString();
        EditText ed1 = (EditText) findViewById(R.id.password);
        String str2 = ed1.getText().toString();

        if (str1.toString().equals("admin")&& str2.toString().equals("admin")) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        } else
            Toast.makeText(getApplicationContext(), "账号或者密码错误"+str1+str2, Toast.LENGTH_SHORT).show();
    }
}
