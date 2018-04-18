package xyz.liyanan.qqregister_test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //多级菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        //获取MenuInflater
        MenuInflater inflater = getMenuInflater();
        //加载menu资源
        inflater.inflate(R.menu.multi, menu);
        //返回值必须为true，不然菜单无法显示
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.files:
                return true;
            case R.id.new_file:
                return true;
            case R.id.file_save:
                return true;
            case R.id.file_more:
                return true;
            case R.id.file_help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
