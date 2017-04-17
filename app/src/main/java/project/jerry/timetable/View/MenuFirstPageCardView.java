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
import project.jerry.timetable.Binding.handler.BaseEventHandler;
import project.jerry.timetable.Binding.handler.MenuEventHandler;
import project.jerry.timetable.Datastore.MenuItemDatastore;
import project.jerry.timetable.R;
import project.jerry.timetable.Util.RecyclerViewDividerDecoration;

/**
 * Created by Migme_Jerry on 2017/4/12.
 */

public class MenuFirstPageCardView extends BaseMenuCardView {

    private final String TAG = "MenuFirstPageCardView";

    private List<MenuItem> mDataList;
    private ViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public MenuFirstPageCardView(Context context) {
        super(context);
    }

    public MenuFirstPageCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuFirstPageCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void addContentView() {
        mAdapter = new ViewAdapter();
        mRecyclerView = new RecyclerView(mContext);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerViewDividerDecoration(mContext));

        // Add view to card view
        mCardView.addView(mRecyclerView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    protected void initData() {
        mDataList = MenuItemDatastore.getInstance().getPageData(MenuItemDatastore.FIRST_CARD);
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
        protected BaseEventHandler getHandler() {
            return new MenuEventHandler(mContext);
        }

        @Override
        protected int getLayoutIdForPosition(int position) {
            return R.layout.view_menu_item;
        }

        @Override
        protected int getTotalItemCount() {
            return mDataList.size();
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
