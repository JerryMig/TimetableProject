package project.jerry.timetable.View;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
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
    private Snackbar mSnackbar;
    private ShowMenuListener showMenuListener;

    private boolean isMenuNeeded;
    private boolean isBottomAnimationStarted;

    private OnLongClickListener mLongClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Log.d(TAG, "Long Click event");
            isMenuNeeded = true;
            return true;
        }
    };

    private OnClickListener mClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "Short Click event");
            isMenuNeeded = false;
        }
    };

    public interface ShowMenuListener {
        void show();
    }

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
        this.setOnLongClickListener(mLongClickListener);
        this.setOnClickListener(mClickListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int action = event.getAction();

        if (!isBottomAnimationStarted) {
            startButtonTouchAnimation();
        }

        switch (action) {
            case MotionEvent.ACTION_UP:
                isBottomAnimationStarted = false;
                isMenuNeeded = false;
                break;
        }

        return super.onTouchEvent(event);
    }

    public void startIndicator() {
        if (mIndicator != null) {
            Animation indicatorAnim =
                    AnimationUtils.loadAnimation(mContext, R.anim.slide_in_and_out_from_right);
            indicatorAnim.setAnimationListener(new AnimationListenerEx() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    if (mSnackbar != null) {
                        mSnackbar.show();
                    }
                }
            });
            mIndicator.setVisibility(VISIBLE);
            mIndicator.startAnimation(indicatorAnim);
        } else {
            Log.d(TAG, "startIndicator: Indicator line is null");
        }
    }

    public void startButtonTouchAnimation() {
        Log.d(TAG, "startButtonTouchAnimation");
        isBottomAnimationStarted = true;
        startBottomLine();
        startLeftLine();
    }

    // Called when isMenuNeeded is false due to a short click event
    // But the finish animations have NOT been reached.
    private void cancelAnimationHalfway() {
        if (!isMenuNeeded && isBottomAnimationStarted) {
            isBottomAnimationStarted = false;
            hideAllLines();
        }
    }

    private void hideAllLines() {
        mBottomLine.clearAnimation();
        mBottomLine.setVisibility(GONE);

        mLeftLine.clearAnimation();
        mLeftLine.setVisibility(GONE);

        mTopLine.clearAnimation();
        mTopLine.setVisibility(GONE);

        mRightLine.clearAnimation();
        mRightLine.setVisibility(GONE);
    }

    private void startBottomLine() {
        if (ensureView(mBottomLine)) {
            Animation bottom = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
            bottom.setAnimationListener(new AnimationListenerEx() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    cancelAnimationHalfway();
                    if (isSecondSetAnimationNeeded()) {
                        startRightLine();
                    }
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
                    cancelAnimationHalfway();
                    if (isSecondSetAnimationNeeded()) {
                        startTopLine();
                    }
                }
            });
            mLeftLine.setVisibility(VISIBLE);
            mLeftLine.startAnimation(left);
        }
    }

    /**
     * ********************************
     * Below are two finish animations.
     * ********************************
     */

    private void startTopLine() {
        if (ensureView(mTopLine)) {
            Animation top = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
            top.setAnimationListener(new AnimationListenerEx() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    decideShowing();
                }
            });
            mTopLine.setVisibility(VISIBLE);
            mTopLine.startAnimation(top);
        }
     }

    private void startRightLine() {
        if (ensureView(mRightLine)) {
            Log.d(TAG, "startRightLine");
            Animation right = AnimationUtils.loadAnimation(mContext, R.anim.slide_up_left);
            mRightLine.setVisibility(VISIBLE);
            mRightLine.startAnimation(right);
        }
    }

    /**
     * ********************************
     * Above are two finish animations.
     * ********************************
     */

    private boolean isSecondSetAnimationNeeded() {
        // just return isMenuNeeded since it'd be false if a short click event is received and sets it to false.
        return isMenuNeeded;
    }

    // This is called when one of the finishing animations is over.
    // Set isBottomAnimationStarted to false since all animations have finished.
    // Set isMenuNeeded to false since menu has shown.
    private void decideShowing() {
        if (showMenuListener != null && isMenuNeeded) {
            showMenuListener.show();
            isMenuNeeded = false;
        }
        hideAllLines();
    }

    private boolean ensureView(View view) {
        if (view == null) {
            Log.d(TAG, "ensureView: View is null");
            return false;
        }
        return true;
    }

    public void setAnimationEndedFromOutside() {
        isBottomAnimationStarted = false;
    }

    public void setShowMenuListener(ShowMenuListener listener) {
        showMenuListener = listener;
    }

    public void setSnackbar(Snackbar snackbar) {
        mSnackbar = snackbar;
    }
}
