package com.wx.exercise.expand;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wx.exercise.R;
import com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: DomeOfHeaven
 * date : 2021/10/4
 * desc :
 */
public class NotUsedAdapter extends BaseCheckableExpandableRecyclerViewAdapter
        <ParentBean, ChildItem, ParentViewHolder, ChildViewHolder> {

    public List<ParentBean> parents = new ArrayList<>();
    private final List<CheckedItem<ParentBean, ChildItem>> mCheckedSet = new ArrayList<>();

    public NotUsedAdapter(int maxCheckedNum, List<ParentBean> beans) {
        super(maxCheckedNum);
        parents = beans;
    }

    @Override
    public int getGroupCount() {
        return parents.size();
    }

    public void setCheckedSet() {
        //初始化选中数据CheckedSet
        for (int i = 0; i < parents.size(); i++) {
            ParentBean parent = parents.get(i);
            List<ChildItem> children = parent.getChildren();
            if (children.size() > 0) {
                for (int j = 0; j < children.size(); j++) {
                    ChildItem child = children.get(j);
                    if (child.selected) {
                        mCheckedSet.add(new CheckedItem<>(parent, child));
                    }
                }
            }
        }
        setCheckedSet(mCheckedSet);
    }

    @Override
    public ParentBean getGroupItem(int groupIndex) {
        return parents.get(groupIndex);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int groupViewType) {
        return new ParentViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_parent_expand_recycler, parent, false)
        );
    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, ParentBean groupBean, boolean isExpand) {
        holder.bind(groupBean);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int childViewType) {
        return new ChildViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_child_epand_recycler, parent, false)
        );
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, ParentBean groupBean, ChildItem childItem) {
        childViewHolder.bind(childItem);
    }
}
