package project.jerry.timetable.Broadcast;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Migme_Jerry on 2017/4/16.
 */

public class EventObject {

    private Intent mIntent = null;

    public EventObject(String name) {
        mIntent = new Intent(name);
    }

    public Intent getIntent() {
        return mIntent;
    }

    public String getActionName() {
        return mIntent.getAction();
    }

    public void putExtra(String name, Bundle bundle) {
        mIntent.putExtra(name, bundle);
    }

}
