package shproject.com.shpdemo.view.list.demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.base.BaseActivity;
import shproject.com.shpdemo.view.list.RecyclerListView;

/**
 * Created by xus on 2017/3/22.
 */

public class RecyclerListViewActivity extends BaseActivity {
    protected RecyclerListView idRecyclerview;
    private ListAdapter adapter;
    private List<String> lists;

    @Override
    public String showInfo() {
        return "此页面展示为RecyclerView的list形式，代码demo RecyclerListViewActivity 代码包目录：shproject.com.shpdemo.view.list";
    }

    @Override
    public void initView() {
        idRecyclerview = (RecyclerListView) findViewById(R.id.id_recyclerview);
        adapter = new ListAdapter(this);
        adapter.setItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, ListViewHolder view) {
                Toast.makeText(RecyclerListViewActivity.this,"点击 字母"+lists.get(pos),Toast.LENGTH_LONG).show();
            }
        });
        idRecyclerview.setAdapter(adapter);
        setTitle("RecyclerListView");
    }

    @Override
    public void initData() {
        lists=new ArrayList<>();

        for (int i = 'A'; i <= 'Z'; i++) {
            lists.add(((char)i+""));
        }
        adapter.setLists(lists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public int setLayoutId() {
        return R.layout.recycler_list_view_activity;
    }
}
