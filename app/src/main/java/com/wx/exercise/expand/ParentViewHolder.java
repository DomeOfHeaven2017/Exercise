package com.wx.exercise.expand;

import static com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter.CHECK_MODE_ALL;
import static com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter.CHECK_MODE_PARTIAL;

import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.wx.exercise.R;
import com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter;

/**
 * author: DomeOfHeaven
 * date : 2021/10/4
 * desc :
 */
public class ParentViewHolder extends BaseCheckableExpandableRecyclerViewAdapter.BaseCheckableGroupViewHolder<ParentBean> {

    private AppCompatImageView arrow;
    private AppCompatCheckBox select;
    private AppCompatTextView name;

    public ParentViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name_item_parent_expand_recycler);
        select = itemView.findViewById(R.id.select_item_parent_expand_recycler);
        arrow = itemView.findViewById(R.id.arrow_item_parent_expand_recycler);
    }

    @Override
    protected void onExpandStatusChanged(RecyclerView.Adapter relatedAdapter, boolean isExpanding) {
        arrow.setImageResource(isExpanding ? R.drawable.expand_arrow : R.drawable.collapse_arrow);
    }

    public void bind(ParentBean bean) {
        name.setText(bean.name);
    }

    @Override
    public void setCheckMode(int mode, ParentBean parentBean) {
        Log.d("ExpandTEST", "parent mode = "+ mode);
        switch (mode) {
            case CHECK_MODE_ALL:

                break;
            case CHECK_MODE_PARTIAL:
                break;
            default:
                break;
        }
    }

    @Override
    public View getCheckableRegion() {
        return select;
    }
}
