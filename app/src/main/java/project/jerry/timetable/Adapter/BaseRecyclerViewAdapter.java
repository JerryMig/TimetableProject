package project.jerry.timetable.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import project.jerry.timetable.Binding.handler.BaseEventHandler;
import project.jerry.timetable.View.RecyclerViewHolder;

/**
 * Created by Migme_Jerry on 2017/3/30.
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, null, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        // Bind object to view
        Object object = getObjectForPosition(position);
        holder.bindObject(object);

        // Bind handler to view
        BaseEventHandler handler = getHandler();
        holder.bindHandler(handler);

        viewHolderForPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return getTotalItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected void viewHolderForPosition(RecyclerViewHolder holder, int position) {
    }

    protected abstract Object getObjectForPosition(int position);

    protected BaseEventHandler getHandler() {
        return null;
    }

    protected abstract int getLayoutIdForPosition(int position);

    protected abstract int getTotalItemCount();

}
