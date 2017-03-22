package shproject.com.shpdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xus on 2017/3/22.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<MainBean> list = new ArrayList<>();

    public List<MainBean> getList() {
        return list;
    }

    public void setList(List<MainBean> list) {
        this.list = list;
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.main_list_item,null);
        }
        TextView item=(TextView)view.findViewById(R.id.item);
        item.setText(list.get(i).getName());
        return view;
    }
}
