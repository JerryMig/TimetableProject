package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class MainPagerFragment extends BaseFragment {

    private final int PAGER_PAGE_COUNT = 3;
    private final int PAGER_NUM_TRAIN = 0;
    private final int PAGER_NUM_SUBWAY = 1;
    private final int PAGER_NUM_BUS = 2;
    private final String PAGER_TAB_TRAIN = "TRAIN";
    private final String PAGER_TAB_SUBWAY = "SUBWAY";
    private final String PAGER_TAB_BUS = "BUS";

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.view_landing_pager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private PagerAdapter() {
            super(getFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case PAGER_NUM_TRAIN:
                    return new TrainTimeTableFragment();
                case PAGER_NUM_SUBWAY:
                    return new SubwayTimeTableFragment();
                case PAGER_NUM_BUS:
                    return new BusTimeTableFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGER_PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case PAGER_NUM_TRAIN:
                    return PAGER_TAB_TRAIN;
                case PAGER_NUM_SUBWAY:
                    return PAGER_TAB_SUBWAY;
                case PAGER_NUM_BUS:
                    return PAGER_TAB_BUS;
            }
            return null;
        }
    }
}
