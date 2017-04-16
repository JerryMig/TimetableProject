package project.jerry.timetable.Datastore;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import project.jerry.timetable.Binding.data.MenuItem;

/**
 * Created by Migme_Jerry on 2017/4/15.
 */

public class MenuItemDatastore extends BaseDatastore {

    private static final String TAG = "MenuItemDatastore";

    public static final int FIRST_CARD = 0;
    public static final int SECOND_CARD = 1;
    public static final int THIRD_CARD = 2;

    private static MenuItemDatastore sInstance;
    private HashMap<Integer, ArrayList<MenuItem>> mDataMap;

    private String[] mFirstPageStrings = {"Search", "Save / Bookmark", "Reload", "Cool train !"};
    private String[] mSecondPageStrings = {"Departure", "Destination", "Train Type", "Date", "Time"};

    private MenuItemDatastore() {
        Log.d(TAG, "MenuItemDatastore instance created");
        initData();
    }

    public static MenuItemDatastore getInstance() {
        if (sInstance == null) {
            sInstance = new MenuItemDatastore();
        }
        return sInstance;
    }

    private void initData() {
        if (mDataMap == null) {
            mDataMap = new HashMap<>();
            mDataMap.put(FIRST_CARD, getCardArray(FIRST_CARD));
            mDataMap.put(SECOND_CARD, getCardArray(SECOND_CARD));
//            mDataMap.put(THIRD_CARD, )
        }
    }

    private ArrayList getCardArray(int page) {
        ArrayList<MenuItem> array = null;
        String[] stringArray = getStrings(page);
        if (stringArray != null) {
            array = new ArrayList<>();
            for (String name : stringArray) {
                MenuItem item = new MenuItem(name, itemHasNextPage(name));
                array.add(item);
            }
        }
        return array;
    }

    private String[] getStrings(int page) {
        switch (page) {
            case FIRST_CARD:
                return mFirstPageStrings;
            case SECOND_CARD:
                return mSecondPageStrings;
            case THIRD_CARD:
                break;
        }
        return null;
    }

    private boolean itemHasNextPage(String name) {
        if (name.equals("Search")) {
            return true;
        }
        return false;
    }

    public ArrayList<MenuItem> getPageData(int page) {
        if (mDataMap != null) {
            return mDataMap.get(page);
        }
        return null;
    }

}
