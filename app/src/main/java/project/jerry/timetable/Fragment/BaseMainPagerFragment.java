package project.jerry.timetable.Fragment;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import project.jerry.timetable.Handler.ActionHandler;
import project.jerry.timetable.R;
import project.jerry.timetable.View.BottomButtonView;

/**
 * Created by Migme_Jerry on 2017/3/28.
 */

public abstract class BaseMainPagerFragment extends BaseFragment {

    private final String TAG = "BaseMainPagerFragment";
    protected BottomButtonView mBottomButtonView;
    private BottomButtonView.ShowMenuListener
            mShowMenuListener = new BottomButtonView.ShowMenuListener() {
        @Override
        public void show() {
            ActionHandler.getInstance().displayFirstPageOfMenu(getContext());
        }
    };

    protected abstract int getLayoutId();

    protected void addBottomButtonView() {
        Log.d(TAG, "addBottomButtonView");
        if (mRootView != null) {
            makeSnackBar();
            ViewGroup viewGroup = (ViewGroup) mRootView.findViewById(R.id.main_container);
            if (viewGroup != null) {
                mBottomButtonView = new BottomButtonView(mContext);
                mBottomButtonView.setSnackbar(makeSnackBar());
                mBottomButtonView.setShowMenuListener(mShowMenuListener);
                viewGroup.addView(mBottomButtonView, generateParamsForButton());
                mBottomButtonView.startIndicator();
            }
        }
    }

    private RelativeLayout.LayoutParams generateParamsForButton() {
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.height = (int) getResources().getDimension(R.dimen.bottom_button_height);
        return params;
    }

    private Snackbar makeSnackBar() {
        final Snackbar snackbar = Snackbar.make(mRootView, "hold and press here for menu", Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.action_bar));
        snackBarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        return snackbar;
    }

}
