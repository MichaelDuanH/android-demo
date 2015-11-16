package com.volley;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public class NetworkImageView extends ImageView {
    private String mUrl;
    private int mDefaultImageId;
    private int mErrorImageId;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
