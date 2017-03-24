package project.jerry.timetable.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.q42.android.scrollingimageview.ScrollingImageView;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class ScrollingTrainView extends LinearLayout {

    private Context mContext;
    private ScrollingImageView mBackBG, mForeBG, mRoad;
    private PaletteImageView mTrain;

    public ScrollingTrainView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ScrollingTrainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public ScrollingTrainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = inflate(mContext, R.layout.scrolling_train, this);
        mBackBG = (ScrollingImageView) view.findViewById(R.id.back_background);
        mForeBG = (ScrollingImageView) view.findViewById(R.id.fore_background);
        mRoad = (ScrollingImageView) view.findViewById(R.id.surface_road);
        mTrain = (PaletteImageView) view.findViewById(R.id.locomotive);
        animateTrain();
    }

    private void animateTrain() {
        Animation jumping = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -0.035f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.015f);
        jumping.setDuration(250);
        jumping.setRepeatCount(-1);
        jumping.setRepeatMode(Animation.REVERSE);
        jumping.setInterpolator(new LinearInterpolator());


//        final Animation jumping = AnimationUtils.loadAnimation(mContext, R.anim.jumping);
//        jumping.setRepeatCount(Animation.INFINITE);
//        jumping.setRepeatMode(Animation.REVERSE);
        mTrain.startAnimation(jumping);
        Log.d("animation", "animateTrain: jumping");
    }

}
