package com.wx.exercise.expand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wx.exercise.R;
import com.wx.exercise.expand.lib.BaseExpandableRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * author: DomeOfHeaven
 * date : 2021/10/4
 * desc :
 */
public class ExpandRecyclerFragment extends Fragment {

    private RecyclerView mRecycler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expand_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycler = view.findViewById(R.id.recycler_expand_fragment);

        List<ParentBean> parents = new ArrayList<>();
        List<ChildItem>  c1 = new ArrayList<>();
        c1.add(new ChildItem("马毅敏", false));
        c1.add(new ChildItem("邓宁", false));
        c1.add(new ChildItem("梁佳睿", false));
        c1.add(new ChildItem("马玥", false));
        ParentBean p1 = new ParentBean("天水", c1);
        parents.add(p1);

        List<ChildItem>  c2 = new ArrayList<>();
        c2.add(new ChildItem("赵郑成", false));
        c2.add(new ChildItem("周思彤", false));
        c2.add(new ChildItem("马莹", false));
        c2.add(new ChildItem("张紫妍", false));
        c2.add(new ChildItem("汪宇", false));
        ParentBean p2 = new ParentBean("深圳", c2);
        parents.add(p2);

        List<ChildItem>  c3 = new ArrayList<>();
        c3.add(new ChildItem("杨幂", false));
        c3.add(new ChildItem("唐嫣", false));
        c3.add(new ChildItem("刘亦菲", false));
        c3.add(new ChildItem("景甜", false));
        c3.add(new ChildItem("陆婷玉", false));
        c3.add(new ChildItem("安咏畅", false));
        c3.add(new ChildItem("王秋紫", false));
        ParentBean p3 = new ParentBean("大陆", c3);
        parents.add(p3);

        List<ChildItem>  c4 = new ArrayList<>();
        c4.add(new ChildItem("铃木爱理", false));
        c4.add(new ChildItem("道重沙由美", false));
        c4.add(new ChildItem("白石麻衣", false));
        c4.add(new ChildItem("斋藤飞鸟", false));
        c4.add(new ChildItem("武田玲奈", false));
        c4.add(new ChildItem("新木优子", false));
        ParentBean p4 = new ParentBean("日本", c4);
        parents.add(p4);

        final NotUsedAdapter adapter = new NotUsedAdapter(7, parents);
        mRecycler.setAdapter(adapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setCheckedSet();
        adapter.expandAll();
    }
}
