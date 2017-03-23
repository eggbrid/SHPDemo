package shproject.com.shpdemo.mvp.model;

import java.util.ArrayList;
import java.util.List;

import shproject.com.shpdemo.mvp.other.BeanCallBack;

/**
 * Created by xus on 2017/3/23.
 * 对于书本实例的地方，主要负责书籍存储
 * 数据获取等
 */

public class BookImp extends BaseImp implements Book {

    @Override
    public List<BookModel> getBookList() {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            BookModel bookModel = new BookModel();
            bookModel.setName("书籍" + i);
            bookModel.setAother("作者" + i);
            bookModel.setPageSize("" + i);
            list.add(bookModel);
        }
        return list;
    }

    @Override
    public void getBook(String bookId, BeanCallBack<BookModel> callBack) {
        moniDoHttp(bookId, callBack);
    }

    /**
     * 目前是测试请求，后期请求类可以封装，callback模型可以用泛型代替
     * @param bookId
     * @param callBack
     */
    public void moniDoHttp(final String bookId, final BeanCallBack<BookModel> callBack) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    callBack.onError(e.toString());
                }
                BookModel bookModel = new BookModel();
                bookModel.setName("书籍" + bookId);
                bookModel.setAother("作者" + bookId);
                bookModel.setPageSize("" + bookId);
                callBack.onSuccess(bookModel);
            }
        });
        thread.start();
    }


}
