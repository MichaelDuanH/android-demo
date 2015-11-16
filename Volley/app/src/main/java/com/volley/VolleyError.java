package com.volley;

import android.net.NetworkRequest;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public class VolleyError extends Exception{
    public final NetworkResponse networkResponse;
    private long networkTimeMs;
    public VolleyError(){
        networkResponse = null;
    }

    public VolleyError(NetworkResponse response){
        networkResponse = response;
    }

    public VolleyError(String exceptionMsg){
        super(exceptionMsg);
        networkResponse = null;
    }

    public VolleyError(String exceptionMsg,Throwable reasons){
         super(exceptionMsg,reasons);
        networkResponse = null;
    }

    public VolleyError(Throwable reasons){
        super(reasons);
        networkResponse = null;
    }

    public NetworkResponse getNetworkResponse() {
        return networkResponse;
    }

    public long getNetworkTimeMs() {
        return networkTimeMs;
    }

    public void setNetworkTimeMs(long networkTimeMs) {
        this.networkTimeMs = networkTimeMs;
    }
}
