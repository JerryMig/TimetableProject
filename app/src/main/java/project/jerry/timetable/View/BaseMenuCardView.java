package project.jerry.timetable.View;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import project.jerry.timetable.Binding.data.MenuItem;
import project.jerry.timetable.R;
import project.jerry.timetable.Util.RecyclerViewDividerDecoration;

/**
 * Created by Migme_Jerry on 2017/4/15.
 */

public abstract class BaseMenuCardView extends LinearLayout {

    private final String TAG = "BaseMenuCardView";
    protected Context mContext;
    protected CardView mCardView;

    public BaseMenuCardView(Context context) {
        super(context);
        mContext = context;
        initData();
        initView();
    }

    public BaseMenuCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        initView();
    }

    public BaseMenuCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initData();
        initView();
    }

    private void initView() {
        View view = inflate(mContext, R.layout.card_menu_base, this);
        mCardView = (CardView) view.findViewById(R.id.view_container);
        addContentView();
    }

    protected abstract void addContentView();

    protected void initData() {

    }
}
