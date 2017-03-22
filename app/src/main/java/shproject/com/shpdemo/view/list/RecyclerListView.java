package shproject.com.shpdemo.view.list;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by xus on 2017/3/22.
 */

public class RecyclerListView extends RecyclerView {
    private Context context;

    public RecyclerListView(Context context) {
        super(context);
        this.context = context;
        initDefultSetting();
    }

    public RecyclerListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initDefultSetting();
    }

    public RecyclerListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initDefultSetting();

    }

    public void initDefultSetting() {
        setLayoutManager(new LinearLayoutManager(context));
        addItemDecoration(new DefaultItemLine(context, DefaultItemLine.VERTICAL_LIST));

    }
}
