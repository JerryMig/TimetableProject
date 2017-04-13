package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import project.jerry.timetable.R;
import project.jerry.timetable.View.ScrollOptionalViewPager;

/**
 * Created by Migme_Jerry on 2017/3/28.
 */

public class MenuPagerFragment extends BaseFragment {

    private final int PAGE_COUNT = 3;

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
    }

    private class MenuPagerAdapter extends FragmentStatePagerAdapter {

        MenuPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }

}
