package project.jerry.timetable.Broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import project.jerry.timetable.App.ApplicationEx;

/**
 * Created by Migme_Jerry on 2017/4/16.
 */

public class BroadcastHandler {

    private final static String TAG = "BroadcastHandler";

    private static BroadcastHandler sInstance;

    private BroadcastHandler() {
    }

    public static BroadcastHandler getInstance() {
        if (sInstance == null) {
            sInstance = new BroadcastHandler();
        }
        return sInstance;
    }

    private void broadcastWithName(String name) {
        EventObject event = new EventObject(name);
        broadcastEvent(event);
    }

    private void broadcastEvent(EventObject event) {
        Context context = ApplicationEx.getContext();
        if (context != null) {
            Intent intent = event.getIntent();
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    public void sendMenuPageUp() {
        broadcastWithName(Events.Menu.PAGE_UP);
    }

    public void sendMenuPageDown() {
        broadcastWithName(Events.Menu.PAGE_DOWN);
    }

}
