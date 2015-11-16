package com.volley;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public class Response {
    public interface Listener<T>{
        public void onResponse(T response);
    }
    public interface ErrorListener{
        public void onErrorResponse(VolleyError error);
    }
}
