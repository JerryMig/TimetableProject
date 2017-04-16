package project.jerry.timetable.View;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import project.jerry.timetable.Adapter.BaseRecyclerViewAdapter;
import project.jerry.timetable.Binding.data.MenuItem;
import project.jerry.timetable.Datastore.MenuItemDatastore;
import project.jerry.timetable.R;
import project.jerry.timetable.Util.RecyclerViewDividerDecoration;

/**
 * Created by Migme_Jerry on 2017/4/15.
 */

public class MenuSecondPageCardView extends BaseMenuCardView {

    private final String TAG = "MenuSecondPageCardView";

    private ArrayList<MenuItem> mDataList;
    private RecyclerView mRecyclerView;
    private ViewAdapter mAdapter;

    public MenuSecondPageCardView(Context context) {
        super(context);
    }

    public MenuSecondPageCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuSecondPageCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void addContentView() {
        mRecyclerView = new RecyclerView(mContext);
        mAdapter = new ViewAdapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.addItemDecoration(new RecyclerViewDividerDecoration(mContext));
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        // Add view to card view
        mCardView.addView(mRecyclerView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void initData() {
        mDataList = MenuItemDatastore.getInstance().getPageData(MenuItemDatastore.SECOND_CARD);
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
            return R.layout.view_menu_second_item;
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
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.clickable_linear);
                    int marginTop = (int) getResources().getDimension(R.dimen.menu_item_height);
                    int padding = (int) getResources().getDimension(R.dimen.menu_text_margin);
                    RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(1000, marginTop);
                    relativeLayout.setLayoutParams(params);
                    view.setPadding(0, padding, 0, 0);
                }
            }
        }
    }

}
