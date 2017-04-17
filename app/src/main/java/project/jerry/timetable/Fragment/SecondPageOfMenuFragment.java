package project.jerry.timetable.Fragment;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import project.jerry.timetable.Adapter.BaseRecyclerViewAdapter;
import project.jerry.timetable.R;
import project.jerry.timetable.View.RecyclerViewHolder;

/**
 * Created by Migme_Jerry on 2017/4/15.
 */

public class SecondPageOfMenuFragment extends BaseRecyclerViewFragment {

    private final String TAG = "SecondPageOfMenuFragment";
    private final Object[] ITEM_OTHER_COUNT = {VIEW_POSITION_HEADER, VIEW_POSITION_CONTENT ,VIEW_POSITION_FOOTER};

    @NonNull
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ViewAdapter();
    }

    private class ViewAdapter extends BaseRecyclerViewAdapter {

        @Override
        protected Object getObjectForPosition(int position) {
            // No data needed
            return null;
        }

        @Override
        protected int getLayoutIdForPosition(int position) {
            switch (position) {
                case VIEW_POSITION_HEADER:
                    return R.layout.view_transparent_header;
                case VIEW_POSITION_CONTENT:
                    return R.layout.view_card_and_recycler_second;
                case VIEW_POSITION_FOOTER:
                    return R.layout.view_second_menu_footer;
            }
            return 0;
        }

        @Override
        protected int getTotalItemCount() {
            return ITEM_OTHER_COUNT.length;
        }

        @Override
        protected void viewHolderForPosition(RecyclerViewHolder holder, int position) {
            View view = holder.getBinding().getRoot();
            switch (position) {
                case VIEW_POSITION_HEADER:
                    adjustHeaderView(view);
                    break;
                case VIEW_POSITION_FOOTER:
                    adjustFooterView(view);
                    break;
            }
        }

        private void adjustHeaderView(View view) {
            if (view != null) {
                View header = view.findViewById(R.id.header_view);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400);
                header.setLayoutParams(params);
            }
        }

        private void adjustFooterView(View view) {
            if (view != null) {
                CardView cardBack = (CardView) view.findViewById(R.id.card_back);
                CardView cardSwitch = (CardView) view.findViewById(R.id.card_switch);
                CardView cardSearch = (CardView) view.findViewById(R.id.card_search);

                int height = (int) getResources().getDimension(R.dimen.menu_item_height);
                Display display = getActivity().getWindowManager().getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                int width = point.x;

                int paddingInBetween = (int) getResources().getDimension(R.dimen.menu_footer_padding);
                int widthEach = (width / 3) - (int)(paddingInBetween * 2.5);

                LinearLayout.LayoutParams paramsBack = new LinearLayout.LayoutParams(widthEach, height);
                paramsBack.rightMargin = paddingInBetween;
                cardBack.setLayoutParams(paramsBack);

                LinearLayout.LayoutParams paramsSwitch = new LinearLayout.LayoutParams(widthEach, height);
                cardSwitch.setLayoutParams(paramsSwitch);

                LinearLayout.LayoutParams paramsSearch = new LinearLayout.LayoutParams(widthEach, height);
                paramsSearch.leftMargin = paddingInBetween;
                cardSearch.setLayoutParams(paramsSearch);
            }
        }

    }

}
