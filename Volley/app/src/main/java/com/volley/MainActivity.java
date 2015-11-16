package com.volley;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    private Button button;
    private TextView tv_result;
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_1);
        tv_result = (TextView) findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_1:
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("account","13760215482");
                        params.put("type",String.valueOf(2));
                        StringRequest postRequest = new StringRequest(Request.Method.POST,"http://dev.weitoo.com:80/server/pub/common/sendShortMsg", new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                tv_result.setVisibility(View.VISIBLE);
                                tv_result.setText(response.toString());
                            }
                        },new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        },params);
                        rq.add(postRequest);
                        break;
                }
            }
        });


    }
}
