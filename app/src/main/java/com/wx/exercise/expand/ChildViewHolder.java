package com.wx.exercise.expand;

import static com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter.CHECK_MODE_ALL;
import static com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter.CHECK_MODE_PARTIAL;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;

import com.wx.exercise.R;
import com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter;

/**
 * author: DomeOfHeaven
 * date : 2021/10/4
 * desc :
 */
public class ChildViewHolder extends BaseCheckableExpandableRecyclerViewAdapter.BaseCheckableChildViewHolder<ChildItem> {
    private AppCompatTextView name;
    private AppCompatCheckBox select;

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name_item_child_expand_recycler);
        select = itemView.findViewById(R.id.select_item_child_expand_recycler);
    }

    public void bind(ChildItem bean) {
        name.setText(bean.nme);
        select.setChecked(bean.selected);
    }

    @Override
    public void setCheckMode(int mode, ChildItem childItem) {
        Log.d("ExpandTEST", "child mode = "+ mode);
        switch (mode) {
            case CHECK_MODE_ALL:
                childItem.selected = true;
                break;
            case CHECK_MODE_PARTIAL:
                break;
            default:
                childItem.selected = false;
                break;
        }
    }

    @Override
    public View getCheckableRegion() {
        return select;
    }
}
