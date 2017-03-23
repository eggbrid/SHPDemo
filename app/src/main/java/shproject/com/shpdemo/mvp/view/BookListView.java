package shproject.com.shpdemo.mvp.view;

import java.util.List;

import shproject.com.shpdemo.mvp.model.BookModel;

/**
 * Created by xus on 2017/3/23.
 */

public interface BookListView {
     void onGetBookListSuccess(List<BookModel> list);
    void onGetBookListError(String error);

}
