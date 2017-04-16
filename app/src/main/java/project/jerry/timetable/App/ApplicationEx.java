package project.jerry.timetable.App;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Migme_Jerry on 2017/4/16.
 */

public class ApplicationEx extends Application {

    private static final String TAG = "ApplicationEx";
    private static ApplicationEx sInstance;

    public static ApplicationEx getInstance() {
        return sInstance;
    }

    private static void setInstance(ApplicationEx app) {
        if (sInstance == null) {
            sInstance = app;
        } else {
            Log.d(TAG, "Instance has been instantiated");
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }
}
