package com.wx.exercise.expand;


import com.wx.exercise.expand.lib.BaseCheckableExpandableRecyclerViewAdapter;
import com.wx.exercise.expand.lib.BaseExpandableRecyclerViewAdapter;

import java.util.List;

/**
 * author: DomeOfHeaven
 * date : 2021/10/4
 * desc :
 */
public class ParentBean implements BaseCheckableExpandableRecyclerViewAdapter.CheckableGroupItem<ChildItem> {

    public String name;
    public List<ChildItem> children;

    public ParentBean(String name, List<ChildItem> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public ChildItem getChildAt(int childIndex) {
        return children.get(childIndex);
    }

    @Override
    public boolean isExpandable() {
        return children.size() > 0;
    }

    @Override
    public List<ChildItem> getChildren() {
        return children;
    }
}
