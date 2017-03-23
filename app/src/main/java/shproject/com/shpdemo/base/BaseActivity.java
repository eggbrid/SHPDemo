package shproject.com.shpdemo.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.base.interfaces.BaseInterface;
import shproject.com.shpdemo.util.dialog.MDialog;

/**
 * Created by xus on 2017/3/14.
 * 目前主流都继承于FragmentActivity
 * 主要是为了更好的管理fragment
 */

public abstract class BaseActivity extends FragmentActivity implements BaseInterface {
    private LinearLayout re;
    private TextView title;
    private TextView back;
    private TextView more;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
        initData();
    }

    private void init() {
        re = new LinearLayout(this);
        re.setBackgroundColor(Color.WHITE);
        re.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layte = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        View view = LayoutInflater.from(this).inflate(setLayoutId(), null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.base_show_info, null);
        TextView showInfo = (TextView) view2.findViewById(R.id.info);
        title = (TextView) view2.findViewById(R.id.title);
        back = (TextView) view2.findViewById(R.id.back);
        more=(TextView)view2.findViewById(R.id.more);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseActivity.this.finish();
            }
        });
        showInfo.setText(showInfo());
        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MDialog(BaseActivity.this).showDialog(showInfo());
            }
        });
        re.addView(view2, layte);
        re.addView(view, layte);
        setContentView(re);
    }

    public void setTitle(String titles) {
        title.setText(titles);
    }
    public void setTitleRight(String titles, View.OnClickListener onClickListener) {
        more.setText(titles);
        more.setOnClickListener(onClickListener);
    }
    public abstract int setLayoutId();
}
