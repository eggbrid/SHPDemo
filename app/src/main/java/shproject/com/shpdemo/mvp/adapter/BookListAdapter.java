package shproject.com.shpdemo.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.mvp.model.BookModel;

/**
 * Created by xus on 2017/3/23.
 */

public class BookListAdapter extends BaseAdapter {
    private Context context;
    private List<BookModel> list=new ArrayList<>();

    public List<BookModel> getList() {
        return list;
    }

    public void setList(List<BookModel> list) {
        this.list = list;
    }

    public BookListAdapter(Context context) {
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
        BookModel bookModel=list.get(i);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.mvp_booklist_item, null);
        }
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView page = (TextView) view.findViewById(R.id.page);
        TextView author = (TextView) view.findViewById(R.id.author);
        name.setText("书名："+bookModel.getName());
        page.setText("共"+bookModel.getPageSize()+"页");
        author.setText("作者"+bookModel.getAother());
        return view;
    }
}
