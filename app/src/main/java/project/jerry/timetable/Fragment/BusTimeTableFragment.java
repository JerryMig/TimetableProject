package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class BusTimeTableFragment extends BaseMainPagerFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bus_timetable;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        addBottomButtonView();
    }
}
