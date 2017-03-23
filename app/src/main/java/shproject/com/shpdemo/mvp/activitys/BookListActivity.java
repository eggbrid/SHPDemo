package shproject.com.shpdemo.mvp.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.base.BaseActivity;
import shproject.com.shpdemo.mvp.adapter.BookListAdapter;
import shproject.com.shpdemo.mvp.model.BookImp;
import shproject.com.shpdemo.mvp.model.BookModel;
import shproject.com.shpdemo.mvp.presenter.BookPersenterImp;
import shproject.com.shpdemo.mvp.view.BookListView;

/**
 * Created by xus on 2017/3/23.
 */

public class BookListActivity extends BaseActivity implements BookListView {
    protected ListView list;
    private BookPersenterImp bookPersenterImp;
    private BookListAdapter adapter;

    @Override
    public void onGetBookListSuccess(List<BookModel> list) {
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetBookListError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public String showInfo() {
        return "此页面是实现mvp框架展示，代码 BookListActivity " +
                "流程：activity中驱动 BookPersenterImp 获取数据" +
                " BookPersenterImp 通过 BookListView 反馈数据信息 实现了mvp核心思想 " +
                "view同model无交互 通过persenter作为中间人交互";
    }

    @Override
    public void initView() {
        list = (ListView) findViewById(R.id.list);
        bookPersenterImp = new BookPersenterImp(new BookImp(), this);
        adapter = new BookListAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BookListActivity.this, BookActivity.class);
                intent.putExtra("id", i + "");
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        setTitle("mvp实例");
        setTitleRight("列表2", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookListActivity.this, AllBookActivity.class));
            }
        });
        bookPersenterImp.getBookList();
    }

    @Override
    public int setLayoutId() {
        return R.layout.mvp_booklist_activity;
    }
}
