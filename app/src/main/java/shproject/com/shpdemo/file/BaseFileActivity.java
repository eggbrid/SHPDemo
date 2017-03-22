package shproject.com.shpdemo.file;

import android.os.Bundle;
import android.support.annotation.Nullable;

import shproject.com.shpdemo.base.BaseActivity;
import shproject.com.shpdemo.base.interfaces.BaseInterface;

/**
 * Created by xus on 2017/3/14.
 * 该类是所有file功能的基类
 *
 */
public abstract class BaseFileActivity extends BaseActivity implements BaseInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
