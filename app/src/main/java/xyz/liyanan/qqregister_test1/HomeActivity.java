package xyz.liyanan.qqregister_test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toListView(View view) {
        Intent intent = new Intent(this, RailwayActivity.class);
        startActivity(intent);
    }

    public void toRunning(View view) {
        Intent intent = new Intent(this, RunningActivity.class);
        startActivity(intent);
    }

    public void toDraw(View view) {
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }

    public void toMenu(View view){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }


}
