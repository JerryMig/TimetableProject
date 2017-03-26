package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import project.jerry.timetable.R;
import project.jerry.timetable.View.BottomButtonView;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class TrainTimeTableFragment extends BaseFragment {

    private View mIndicator;
    private Snackbar mSnackbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_train_timetable;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        mIndicator = (View) view.findViewById(R.id.indicator_line);
        BottomButtonView bottomButtonView = (BottomButtonView) view.findViewById(R.id.bottom_button);
        bottomButtonView.startButtonTouchAnimation();
//        animateIndicator();
//        makeSnackBar(view);
    }

    private void animateIndicator() {
        Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_and_out_from_right);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (mSnackbar != null) {
                    mSnackbar.show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIndicator.startAnimation(anim);
    }

    private void makeSnackBar(View view) {
        mSnackbar = Snackbar.make(view, "hold and press here for menu", Snackbar.LENGTH_INDEFINITE);
        View snackBarView = mSnackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.action_bar));
        snackBarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar.dismiss();
            }
        });
    }
}
