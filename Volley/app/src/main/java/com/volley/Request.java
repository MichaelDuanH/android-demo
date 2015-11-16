package com.volley;

import java.util.Map;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public abstract class  Request<T> implements Comparable<Request<T>> {

    protected Map<String,String> mParams = null;
    private final int mMethod;
    private final String mUrl;
    private final Response.ErrorListener mErrorListener;
    private RequestQueue mRequestQueue;
    private Integer mSequence;
    private boolean mShouldCache = true;

    public Map<String, String> getmParams() {
        return mParams;
    }


    public void setmParams(Map<String, String> mParams) {
        this.mParams = mParams;
    }

    private static final String DEFAULT_PARAM_ENCODDING="UTF-8";
    public interface Method {
        int POST = 1;
        int GET = 2;
    }
    private final VelleyLog.MarkerLog markerLog = VelleyLog.MarkerLog.ENABLED?new VelleyLog.MarkerLog():null;

    public Request(int method,String url,Response.ErrorListener listener){
        mMethod = method;
        mUrl = url;
        mErrorListener = listener;
    }

    public String getUrl() {
        return mUrl;
    }
    public Request<?> setRequestQueue(RequestQueue requestQueue){
        this.mRequestQueue = requestQueue;
        return this;
    }

    public final Request<?> setSequence(int sequence){
        mSequence = sequence;
        return this;
    }

    public void addMarker(String tag){
        if(VelleyLog.MarkerLog.ENABLED){

        }
    }
    public final boolean shouldCatch(){
         return shouldCatch();
    }

    public String getCacheKey(){
        return getUrl();
    }
}
