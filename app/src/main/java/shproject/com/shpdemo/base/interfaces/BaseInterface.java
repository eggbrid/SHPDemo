package shproject.com.shpdemo.base.interfaces;

/**
 * Created by xus on 2017/3/14.
 */

public interface BaseInterface {
    /**
     * 该类所能实现的功能的文字描述
     * 在baseFileActivity 中调用
     *
     * @return
     */
    String showInfo();
    void initView();
    void initData();
}
