package shproject.com.shpdemo.mvp.model;

import java.util.List;

import shproject.com.shpdemo.mvp.other.BeanCallBack;

/**
 * Created by xus on 2017/3/23.
 *
 * 书本数据操作接口
 */

public interface Book {
     /**
      * 实时获取列表 有获取数据时阻塞
      * @return
      */
     List<BookModel> getBookList();

     /**
      * 异步获取详情，无获取数据阻塞
      * @param bookId
      * @param callBack
      */
     void getBook(String bookId, BeanCallBack<BookModel> callBack);
}
