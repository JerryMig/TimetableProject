package project.jerry.timetable.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/24.
 */

public class PaletteImageView extends ImageView {

    private Context mContext;
    public PaletteImageView(Context context) {
        super(context);
        mContext = context;
    }

    public PaletteImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setForeColor(context, attrs);
        mContext = context;
    }

    public PaletteImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setForeColor(context, attrs);
        mContext = context;
    }

    /***
     * overlapped forecolor of icon image
     */
    private void setForeColor(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PaletteImageView);
        int color = typedArray.getColor(R.styleable.PaletteImageView_foreColor, context.getResources().getColor(R.color.action_bar));
        changeForeColor(color);
        typedArray.recycle();
    }

    /**
     * @param colorResourceId color id. ex: R.color.white
     */
    public void setForeColor(int colorResourceId) {
        int color = mContext.getResources().getColor(colorResourceId);
        changeForeColor(color);
    }

    private void changeForeColor(int color) {
        Bitmap sourceBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        Bitmap copiedBitmap = sourceBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint = new Paint();

        ColorFilter filter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
        paint.setColorFilter(filter);

        Canvas canvas = new Canvas(copiedBitmap);
        canvas.drawBitmap(copiedBitmap, 0, 0, paint);
        setImageBitmap(copiedBitmap);
    }

}
