package project.jerry.timetable.Binding.handler;

import android.content.Context;
import android.util.Log;

import project.jerry.timetable.Binding.data.MenuItem;
import project.jerry.timetable.Broadcast.BroadcastHandler;

/**
 * Created by Migme_Jerry on 2017/4/11.
 */

public class MenuEventHandler extends BaseEventHandler {

    private final String TAG = "MenuEventHandler";

    public MenuEventHandler(Context context) {
        super(context);
    }

    public void onItemClick(MenuItem item) {
        if (item != null) {
            boolean hasNextPage = item.hasNextPage();
            Log.d(TAG, "onItemClick: hasNextPage is " + hasNextPage);
            if (hasNextPage) {
                BroadcastHandler.getInstance().sendMenuPageDown();
            }
        }
    }
}
