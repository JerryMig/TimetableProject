package project.jerry.timetable.Fragment;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import project.jerry.timetable.Adapter.BaseRecyclerViewAdapter;
import project.jerry.timetable.R;
import project.jerry.timetable.View.RecyclerViewHolder;

/**
 * Created by Migme_Jerry on 2017/4/10.
 */

public class FirstPageOfMenuFragment extends BaseRecyclerViewFragment {

    private final String TAG = "FirstPageOfMenuFragment";
    private final int VIEW_POSITION_HEADER = 0;
    private final int VIEW_POSITION_CONTENT = 1;
    private final int VIEW_POSITION_FOOTER = 2;
    private final Object[] ITEM_OTHER_COUNT = {VIEW_POSITION_HEADER, VIEW_POSITION_CONTENT ,VIEW_POSITION_FOOTER};

    private FirstPagerRecyclerViewAdapter mAdapter;

    @NonNull
    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new FirstPagerRecyclerViewAdapter();
        return mAdapter;
    }

    private class FirstPagerRecyclerViewAdapter extends BaseRecyclerViewAdapter {

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
                    return R.layout.view_card_and_recycler;
                case VIEW_POSITION_FOOTER:
                    return R.layout.view_menu_footer;
            }
            return 0;
        }

        @Override
        protected int getTotalItemCount() {
            return ITEM_OTHER_COUNT.length;
        }

        @Override
        protected void viewHolderForPosition(RecyclerViewHolder holder, int position) {
            if (holder != null) {
                ViewDataBinding binding = holder.getBinding();
                if (binding != null) {
                    View view = binding.getRoot();
                    switch (position) {
                        case VIEW_POSITION_HEADER:
                            break;
                        case VIEW_POSITION_CONTENT:
                            doSlideInBottomAnimation(view, null);
                            break;
                        case VIEW_POSITION_FOOTER:
                            break;
                    }
//                    ViewGroup.LayoutParams params = view.getLayoutParams();
//                    view.getLayoutParams().width = 500;
//
//                    int height = (int) (parent.getMeasuredHeight() / (float) 1.65);
//                    RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                            ViewGroup.LayoutParams.WRAP_CONTENT);
//                    params.setMargins(30, 0, 30, 0);
//                    view.setLayoutParams(params);
                }
            }
        }

        private void doSlideInBottomAnimation(View v, Animation.AnimationListener listener) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_bottom);
            doAnimationOnView(animation, v, listener);
        }

        private void doAnimationOnView(Animation anim, View v, Animation.AnimationListener listener) {
            if (v != null && anim != null) {
                anim.setAnimationListener(listener);
                anim.setStartOffset(300);
                v.startAnimation(anim);
            }
        }
    }

}
