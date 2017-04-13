package project.jerry.timetable.Binding.handler;

import android.content.Context;

/**
 * Created by Migme_Jerry on 2017/4/11.
 */

public abstract class BaseEventHandler {

    protected Context mContext;

    public BaseEventHandler(Context context) {
        mContext = context;
    }

}
