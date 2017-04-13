package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class TrainTimeTableFragment extends BaseMainPagerFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_train_timetable;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        addBottomButtonView();
    }

}
