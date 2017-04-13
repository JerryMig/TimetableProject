package project.jerry.timetable.View;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import project.jerry.timetable.BR;

/**
 * Created by Migme_Jerry on 2017/3/30.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding mBinding;

    public RecyclerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(Object object) {
        mBinding.setVariable(BR.item, object);
        mBinding.executePendingBindings();
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

}
