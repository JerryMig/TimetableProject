package project.jerry.timetable.View;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import project.jerry.timetable.Adapter.BaseRecyclerViewAdapter;
import project.jerry.timetable.Binding.data.MenuItem;
import project.jerry.timetable.R;
import project.jerry.timetable.Util.RecyclerViewDividerDecoration;

/**
 * Created by Migme_Jerry on 2017/4/12.
 */

public class MenuFirstPageCardView extends LinearLayout {

    private final String TAG = "MenuFirstPageCardView";

    private Context mContext;

    private final String[] mStrings = {"Search", "Save / Bookmark", "Reload", "Cool train !"};
    private final int VIEW_TO_ADJUST = 0;

    private List<MenuItem> mDataList;
    private ViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public MenuFirstPageCardView(Context context) {
        super(context);
        mContext = context;
        initData();
        initView();
    }

    public MenuFirstPageCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        initView();
    }

    public MenuFirstPageCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initData();
        initView();
    }

    private void initView() {
        View view = inflate(mContext, R.layout.card_menu_first, this);
        mAdapter = new ViewAdapter();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerViewDividerDecoration(mContext));
    }

    private void initData() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
            for (String name : mStrings) {
                //TODO Think of a better way to wrap data
                MenuItem menuItem = new MenuItem(name);
                if (name.equals("Search")) {
                    menuItem.setHasNextPage(true);
                }
                Log.d(TAG, "Initiating data name : " + name);
                mDataList.add(menuItem);
            }
        }
    }



    private class ViewAdapter extends BaseRecyclerViewAdapter {

        @Override
        protected Object getObjectForPosition(int position) {
            if (ensureData(position)) {
                return mDataList.get(position);
            }
            return null;
        }

        @Override
        protected int getLayoutIdForPosition(int position) {
            return R.layout.view_menu_item;
        }

        @Override
        protected int getTotalItemCount() {
            return mStrings.length;
        }

        private boolean ensureData(int position) {
            if (mDataList != null && position < mDataList.size()) {
                return true;
            } else {
                Log.d(TAG, "Data ensurance failed!");
                return false;
            }
        }

        @Override
        protected void viewHolderForPosition(RecyclerViewHolder holder, int position) {
            if (holder != null) {
                ViewDataBinding binding = holder.getBinding();
                if (binding != null) {
                    View view = binding.getRoot();
                    /** Setting margin and padding for better looks **/
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.clickable_linear);
                    int marginTop = (int) getResources().getDimension(R.dimen.menu_item_height);
                    int padding = (int) getResources().getDimension(R.dimen.menu_text_margin);
                    RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(1000, marginTop);
                    linearLayout.setLayoutParams(params);
                    view.setPadding(0, padding, 0, 0);
                }
            }
        }
    }

}
