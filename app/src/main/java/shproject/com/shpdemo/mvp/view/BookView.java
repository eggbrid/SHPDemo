package shproject.com.shpdemo.mvp.view;

import shproject.com.shpdemo.mvp.model.BookModel;

/**
 * Created by xus on 2017/3/23.
 */

public interface BookView {
    void onGetBookSuccess(BookModel bookModel);
    void onGetBookError(String string);

    /**
     * 这两个不知道封装到view里，还是在activity里处理 目前封装到view
     */
    void showProsses();
    void disProsses();

}
