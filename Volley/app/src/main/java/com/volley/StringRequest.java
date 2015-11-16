package com.volley;

import java.util.Map;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public class StringRequest extends Request<String> {

   private final Response.Listener<String> pListener;

    public StringRequest(int method,String url,Response.Listener<String> pListener,Response.ErrorListener errorListener) {
        super(method,url,errorListener);
        this.pListener = pListener;
    }

    public StringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener,Map<String,String> params) {
        this(Method.POST, url, listener, errorListener);
        //进行初始化Request中post 请求参数
        setmParams(params);
    }

    @Override
    public int compareTo(Request<String> another) {
        return 0;
    }
}
