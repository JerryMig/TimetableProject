package project.jerry.timetable.View;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import project.jerry.timetable.BR;
import project.jerry.timetable.Binding.handler.BaseEventHandler;

/**
 * Created by Migme_Jerry on 2017/3/30.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding mBinding;

    public RecyclerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindObject(Object object) {
        mBinding.setVariable(BR.item, object);
        mBinding.executePendingBindings();
    }

    public void bindHandler(BaseEventHandler handler) {
        if (handler != null) {
            mBinding.setVariable(BR.handler, handler);
            mBinding.executePendingBindings();
        }
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

}
