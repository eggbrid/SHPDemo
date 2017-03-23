package shproject.com.shpdemo.mvp.other;

/**
 * Created by xus on 2017/3/23.
 */

public interface BeanCallBack<P> {
    void onSuccess(P p);
    void onError(String errorMessage);
}
