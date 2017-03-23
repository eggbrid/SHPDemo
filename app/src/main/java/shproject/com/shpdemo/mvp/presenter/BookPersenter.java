package shproject.com.shpdemo.mvp.presenter;

import shproject.com.shpdemo.mvp.model.Book;

/**
 * Created by xus on 2017/3/23.
 */

public interface BookPersenter  {
     void getBookList();
    void getBook(String id);
}
