package project.jerry.timetable.Util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/4/13.
 */

public class RecyclerViewDividerDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDrawable;

    public RecyclerViewDividerDecoration(Context context) {
        mDrawable = ContextCompat.getDrawable(context, R.drawable.divider);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) == 0) {
            return;
        }

        outRect.top = mDrawable.getIntrinsicHeight();

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int dividerLeft = parent.getPaddingLeft();
        int dividerRight = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int dividerTop = child.getBottom() + params.bottomMargin;
            int dividerBottom = dividerTop + mDrawable.getIntrinsicHeight();
            mDrawable.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            mDrawable.draw(c);
        }
    }
}
