package shproject.com.shpdemo.view.list.demo;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.view.list.BaseRecycleListAdapter;

/**
 * Created by xus on 2017/3/22.
 */

public class ListAdapter extends BaseRecycleListAdapter<ListViewHolder> {
    private List<String> lists = new ArrayList<>();
private OnItemClickListener itemClickListener;

    public OnItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public ListAdapter(Context context) {
        super(context);
    }

    @Override
    public int setItemLayoutId() {
        return R.layout.recycler_list_view_item;
    }

    @Override
    public ListViewHolder setViewHolder(View v) {
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, final int position) {
        holder.text.setText(lists.get(position));
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null){
                    itemClickListener.onItemClick(position,holder);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,ListViewHolder view);
    }
}
