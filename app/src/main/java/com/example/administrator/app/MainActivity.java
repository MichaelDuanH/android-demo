package com.example.administrator.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class MainActivity extends Activity {
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        //通过设置checkbox的监听事件来对checkbox处理
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //通过oncheckchangelistener方法监听当前的checkbox是否被选中
                if(isChecked){
                  //如果为true，获取checkbox的文本内容
                    String tx = checkBox.getText().toString();
                    Log.i("tag", tx);
                }
            }
        });
    }
}
