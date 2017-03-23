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
import shproject.com.shpdemo.mvp.view.AllBookView;
import shproject.com.shpdemo.util.ProcessUtils;
import shproject.com.shpdemo.util.dialog.MDialog;

/**
 * Created by xus on 2017/3/23.
 */

public class AllBookActivity extends BaseActivity implements AllBookView {


    @Override
    public void onGetBookSuccess(final BookModel bookModel) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new MDialog(AllBookActivity.this).showDialog(bookModel.toString());
            }
        });
    }

    @Override
    public void onGetBookError(final String string) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AllBookActivity.this, string,Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void showProsses() {
        ProcessUtils.show(this, "正在获取书籍详情");
    }

    @Override
    public void disProsses() {
        ProcessUtils.dismiss();
    }

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
                bookPersenterImp.getBook(i+"");
            }
        });
    }

    @Override
    public void initData() {
        setTitle("mvp实例");
        bookPersenterImp.getBookList();
    }

    @Override
    public int setLayoutId() {
        return R.layout.mvp_booklist_activity;
    }
}
