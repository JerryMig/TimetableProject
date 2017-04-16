package project.jerry.timetable.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/3/30.
 */

public abstract class BaseRecyclerViewFragment extends BaseFragment {

    protected final int VIEW_POSITION_HEADER = 0;
    protected final int VIEW_POSITION_CONTENT = 1;
    protected final int VIEW_POSITION_FOOTER = 2;

    private RecyclerView mRecyclerView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(getAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_recycler_view;
    }

    @NonNull
    protected abstract RecyclerView.Adapter getAdapter();

}
