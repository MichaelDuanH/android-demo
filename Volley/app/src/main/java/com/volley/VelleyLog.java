package com.volley;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by KD90ZC on 2015/11/16.
 */
public class VelleyLog {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG,Log.VERBOSE);
     static class MarkerLog{
         public static final boolean ENABLED = VelleyLog.DEBUG;
     }
    private static class Marker {
        public final String name;
        public final long thread;
        public final long time;
        public Marker(String name, long thread, long time) {
            this.name = name;
            this.thread = thread;
            this.time = time;
        }
    }
    private final List<Marker> mMarkers = new ArrayList<Marker>();
    private boolean mFinished = false;
    public synchronized void add(String name, long threadId) {
        if (mFinished) {
            throw new IllegalStateException("Marker added to finished log");
        }
        mMarkers.add(new Marker(name, threadId, SystemClock.elapsedRealtime()));
    }

    public static void v(String format, Object... args) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(format, args));
        }
    }

    private static String buildMessage(String format, Object... args) {
        String msg = (args == null) ? format : String.format(Locale.US, format, args);
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();

        String caller = "<unknown>";
        // Walk up the stack looking for the first caller outside of VolleyLog.
        // It will be at least two frames up, so start there.
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(VelleyLog.class)) {
                String callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);

                caller = callingClass + "." + trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s",
                Thread.currentThread().getId(), caller, msg);
    }
}
