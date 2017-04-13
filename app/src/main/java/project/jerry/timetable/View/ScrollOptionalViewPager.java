package project.jerry.timetable.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/29.
 */

public class ScrollOptionalViewPager extends ViewPager {

    private final String TAG = "ScrollOptionalViewPager";
    private Context mContext;
    private boolean mScrollable;

    public ScrollOptionalViewPager(Context context) {
        super(context);
        mContext = context;
    }

    public ScrollOptionalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getScrollable(attrs);
    }

    private void getScrollable(AttributeSet attrs) {
        if (mContext != null) {
            TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.ScrollOptionalViewPager);
            mScrollable = typedArray.getBoolean(R.styleable.ScrollOptionalViewPager_scrollable, true);
            typedArray.recycle();
        } else {
            Log.d(TAG, "setScrollable: mContext is null.");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mScrollable) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mScrollable) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
