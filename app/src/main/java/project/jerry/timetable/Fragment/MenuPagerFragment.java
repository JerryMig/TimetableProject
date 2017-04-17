package project.jerry.timetable.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import project.jerry.timetable.R;
import project.jerry.timetable.Broadcast.Events;
import project.jerry.timetable.View.ScrollOptionalViewPager;

/**
 * Created by Migme_Jerry on 2017/3/28.
 */

public class MenuPagerFragment extends BaseFragment {

    private final String TAG = "MenuPagerFragment";

    private final int PAGE_COUNT = 3;
    private final int PAGE_OPTIONS = 0;
    private final int PAGE_TIME_TABLE = 1;
    private final int PAGE_DETAILS = 2;

    private int mCurrentPage = PAGE_OPTIONS;

    private ScrollOptionalViewPager mViewPager;
    private MenuPagerAdapter mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pager_menu;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewPager = (ScrollOptionalViewPager) view.findViewById(R.id.pager);
        mPagerAdapter = new MenuPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
    }

    @Override
    protected void registerReceivers() {
        registerEvent(Events.Menu.PAGE_UP);
        registerEvent(Events.Menu.PAGE_DOWN);
    }

    @Override
    protected void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive in MenuPagerFragment: " + action);
            switch (action) {
                case Events.Menu.PAGE_UP:
                    pageUp();
                    break;
                case Events.Menu.PAGE_DOWN:
                    pageDown();
                    break;
            }
        }
    }

    private void pageDown() {
        if (mCurrentPage < PAGE_COUNT) {
            mViewPager.setCurrentItem(++mCurrentPage);
        } else {
            Log.d(TAG, "PageDown out of range in menu");
        }
    }

    private void pageUp() {
        if (mCurrentPage > PAGE_OPTIONS) {
            mViewPager.setCurrentItem(--mCurrentPage);
        } else {
            Log.d(TAG, "PageUp out of range in menu");
        }
    }

    private class MenuPagerAdapter extends FragmentStatePagerAdapter {

        MenuPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case PAGE_OPTIONS:
                    return new FirstPageOfMenuFragment();
                case PAGE_TIME_TABLE:
                    return new SecondPageOfMenuFragment();
                case PAGE_DETAILS:
                    return new SecondPageOfMenuFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }

}
