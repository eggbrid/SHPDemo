package shproject.com.shpdemo.mvp.presenter;

import java.util.List;

import shproject.com.shpdemo.mvp.model.BookImp;
import shproject.com.shpdemo.mvp.model.BookModel;
import shproject.com.shpdemo.mvp.other.BeanCallBack;
import shproject.com.shpdemo.mvp.view.AllBookView;
import shproject.com.shpdemo.mvp.view.BookListView;
import shproject.com.shpdemo.mvp.view.BookView;

/**
 * Created by xus on 2017/3/23.
 */

public class BookPersenterImp extends BasePersenterImp implements BookPersenter {
    private BookImp bookImp;
    private AllBookView allBookView;//此处包含book,也包含book列表
    private BookListView bookListView;//此处为book列表
    private BookView bookView;//此处为纯book

    /**
     * 该实现类适用于所有Book相关的view
     *
     * @param bookImp
     * @param allBookView
     */
    public BookPersenterImp(BookImp bookImp, AllBookView allBookView) {
        this.bookImp = bookImp;
        this.allBookView = allBookView;
    }

    /**
     * 该实现类只适用于BookList相关的view
     *
     * @param bookImp
     * @param bookListView
     */
    public BookPersenterImp(BookImp bookImp, BookListView bookListView) {
        this.bookImp = bookImp;
        this.bookListView = bookListView;
    }

    /**
     * 该实现类只适用于Book相关的view
     *
     * @param bookImp
     * @param bookView
     */
    public BookPersenterImp(BookImp bookImp, BookView bookView) {
        this.bookImp = bookImp;
        this.bookView = bookView;
    }

    @Override
    public void getBookList() {

        try {
            List<BookModel> list = bookImp.getBookList();
            if (bookListView != null) {
                bookListView.onGetBookListSuccess(list);
            }
            if (allBookView != null) {
                allBookView.onGetBookListSuccess(list);
            }
        } catch (Exception e) {
            if (bookListView != null) {
                bookListView.onGetBookListError(e.toString());
            }
            if (allBookView != null) {
                allBookView.onGetBookListError(e.toString());
            }
        }

    }

    @Override
    public void getBook(String id) {
        try {
            if (bookView != null) {
                bookView.showProsses();
            }
            if (allBookView != null) {
                allBookView.showProsses();
            }
        bookImp.getBook(id, new BeanCallBack<BookModel>() {
            @Override
            public void onSuccess(BookModel bookModel) {
                if (bookView != null) {
                    bookView.disProsses();
                }
                if (allBookView != null) {
                    allBookView.disProsses();
                }
                if (bookView != null) {
                    bookView.onGetBookSuccess(bookModel);
                }
                if (allBookView != null) {
                    allBookView.onGetBookSuccess(bookModel);
                }
            }

            @Override
            public void onError(String errorMessage) {
                if (bookView != null) {
                    bookView.disProsses();
                }
                if (allBookView != null) {
                    allBookView.disProsses();
                }
                if (bookView != null) {
                    bookView.onGetBookError(errorMessage);
                }
                if (allBookView != null) {
                    allBookView.onGetBookError(errorMessage);
                }
            }
        });
        } catch (Exception e) {
            if (bookView != null) {
                bookView.disProsses();
            }
            if (allBookView != null) {
                allBookView.disProsses();
            }
            if (bookView != null) {
                bookView.onGetBookError(e.toString());
            }
            if (allBookView != null) {
                allBookView.onGetBookError(e.toString());
            }
        }
    }

}
