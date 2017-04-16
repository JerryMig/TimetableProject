package project.jerry.timetable.Handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import project.jerry.timetable.Activity.PopupTranslucentActivity;
import project.jerry.timetable.Fragment.BaseFragment;
import project.jerry.timetable.Fragment.FirstPageOfMenuFragment;

/**
 * Created by Migme_Jerry on 2017/4/11.
 */

public class ActionHandler {

    private static ActionHandler sInstance;
    private static final String TAG = "ActionHandler";

    public static ActionHandler getInstance() {
        if (sInstance == null) {
            sInstance = new ActionHandler();
        }
        return sInstance;
    }

    private ActionHandler() {

    }

    public void displayFirstPageOfMenu(Context context) {
        showFragmentAsCustomPopup(context, null);
    }

    /**
     *
     * Below are general functions for starting Activity.
     *
     * */

    private void showFragmentAsCustomPopup(Context context, BaseFragment fragment) {
//        String fragmentId = cacheFragment(fragment);
        showFragmentWithIdAsCustomPopup(context, false);
    }

    private void showFragmentWithIdAsCustomPopup(Context context, boolean useTranslucentActivity) {
        // ensure we don't have null context
//        context = Tools.ensureContext(context);

        Intent intent = null;
//        if (useTranslucentActivity) {
            intent = new Intent(context, PopupTranslucentActivity.class);
//        }
//        else {
//            intent = new Intent(context, CustomPopupActivity.class);
//        }

        //AD-1470 calling startActivity() from outside of an Activity context requires Intent.FLAG_ACTIVITY_NEW_TASK
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        Log.d("popupActivity", "showFragmentWithIdAsCustomPopup");
        startActivity(context, intent);
    }

    private void startActivity(Context context, Intent intent) {
//        context = Tools.ensureContext(context);
        if (context != null) {
            context.startActivity(intent);
        }
    }

}
