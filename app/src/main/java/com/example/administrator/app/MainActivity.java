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
        //ͨ������checkbox�ļ����¼�����checkbox����
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //ͨ��oncheckchangelistener����������ǰ��checkbox�Ƿ�ѡ��
                if(isChecked){
                  //���Ϊtrue����ȡcheckbox���ı�����
                    String tx = checkBox.getText().toString();
                    Log.i("tag", tx);
                }
            }
        });
    }
}
