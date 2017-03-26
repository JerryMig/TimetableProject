package project.jerry.timetable.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import project.jerry.timetable.Listener.AnimationListenerEx;
import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/25.
 */

public class BottomButtonView extends RelativeLayout {

    private final static String TAG = "BottomButtonView";
    private Context mContext;

    private View mTopLine, mLeftLine, mRightLine, mBottomLine, mIndicator;

    public BottomButtonView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public BottomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public BottomButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = inflate(mContext, R.layout.bottom_button, this);
        mTopLine = view.findViewById(R.id.top_line);
        mLeftLine = view.findViewById(R.id.left_vertical_line);
        mRightLine = view.findViewById(R.id.right_vertical_line);
        mBottomLine = view.findViewById(R.id.bottom_line);
        mIndicator = view.findViewById(R.id.indicator_line);
    }

//    private void setAnimations() {
//        Animation indicatorAnim =
//                AnimationUtils.loadAnimation(mContext, R.anim.slide_in_and_out);
//        mIndicator.setAnimation(indicatorAnim);
//    }

    public void startIndicator() {
        if (mIndicator != null) {
            Animation indicatorAnim =
                    AnimationUtils.loadAnimation(mContext, R.anim.slide_in_and_out_from_right);
            mIndicator.setVisibility(VISIBLE);
            mIndicator.startAnimation(indicatorAnim);
        } else {
            Log.d(TAG, "startIndicator: Indicator line is null");
        }
    }

    public void startButtonTouchAnimation() {
        startBottomLine();
        startLeftLine();
    }

    private void startBottomLine() {
        if (ensureView(mBottomLine)) {
            Animation bottom = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
            bottom.setAnimationListener(new AnimationListenerEx() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    startRightLine();
                }
            });
            mBottomLine.setVisibility(VISIBLE);
            mBottomLine.startAnimation(bottom);
        }
    }

    private void startLeftLine() {
        if (ensureView(mLeftLine)) {
            Animation left = AnimationUtils.loadAnimation(mContext, R.anim.slide_up_left);
            left.setAnimationListener(new AnimationListenerEx() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    startTopLine();
                }
            });
            mLeftLine.setVisibility(VISIBLE);
            mLeftLine.startAnimation(left);
        }
    }

    private void startTopLine() {
        if (ensureView(mTopLine)) {
            Animation top = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
            mTopLine.setVisibility(VISIBLE);
            mTopLine.startAnimation(top);
        }
     }

    private void startRightLine() {
        if (ensureView(mRightLine)) {
            Animation right = AnimationUtils.loadAnimation(mContext, R.anim.slide_up_left);
            mRightLine.setVisibility(VISIBLE);
            mRightLine.startAnimation(right);
        }
    }

    private boolean ensureView(View view) {
        if (view == null) {
            Log.d(TAG, "ensureView: View is null");
            return false;
        }
        return true;
    }
}
