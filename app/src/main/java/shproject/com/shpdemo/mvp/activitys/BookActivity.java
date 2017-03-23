package shproject.com.shpdemo.mvp.activitys;

import android.widget.TextView;
import android.widget.Toast;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.base.BaseActivity;
import shproject.com.shpdemo.mvp.model.BookImp;
import shproject.com.shpdemo.mvp.model.BookModel;
import shproject.com.shpdemo.mvp.presenter.BookPersenterImp;
import shproject.com.shpdemo.mvp.view.BookView;
import shproject.com.shpdemo.util.ProcessUtils;

/**
 * Created by xus on 2017/3/23.
 */

public class BookActivity extends BaseActivity implements BookView {
    protected TextView name;
    protected TextView page;
    protected TextView author;
    private BookPersenterImp bookPersenterImp;
private String id;

    @Override
    public String showInfo() {
        return "此页面是使用异步交互后的mvp avtivity 目前没有将context封装至persenter 所以在activity获取数据时，需要通过uithread获取";
    }

    @Override
    public void initView() {

        name = (TextView) findViewById(R.id.name);
        page = (TextView) findViewById(R.id.page);
        author = (TextView) findViewById(R.id.author);

    }

    @Override
    public void initData() {
        //考虑是否需要把avtivity的穿参也封装至view中
        id=getIntent().getStringExtra("id");
        bookPersenterImp = new BookPersenterImp(new BookImp(), this);
        bookPersenterImp.getBook(id);
    }

    @Override
    public int setLayoutId() {
        return R.layout.mvp_booklist_item;
    }


    @Override
    public void onGetBookSuccess(final BookModel bookModel) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                name.setText("书名："+bookModel.getName());
                page.setText("共"+bookModel.getPageSize()+"页");
                author.setText("作者"+bookModel.getAother());
            }
        });
    }

    @Override
    public void onGetBookError(final String string) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BookActivity.this, string,Toast.LENGTH_LONG).show();

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
}
