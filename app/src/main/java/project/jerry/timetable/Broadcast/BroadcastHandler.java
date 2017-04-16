package project.jerry.timetable.Broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import project.jerry.timetable.App.ApplicationEx;

/**
 * Created by Migme_Jerry on 2017/4/16.
 */

public class BroadcastHandler {

    private static BroadcastHandler sInstance;

    private BroadcastHandler() {
    }

    public static BroadcastHandler getInstance() {
        if (sInstance == null) {
            sInstance = new BroadcastHandler();
        }
        return sInstance;
    }

    public void broadcastEvent(EventObject event) {
        Context context = ApplicationEx.getContext();
        if (context != null) {
            Intent intent = event.getIntent();
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

}
