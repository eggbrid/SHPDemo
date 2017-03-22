package shproject.com.shpdemo.view.list.demo;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import shproject.com.shpdemo.R;
import shproject.com.shpdemo.view.list.BaseViewHolder;

/**
 * Created by xus on 2017/3/22.
 */

public class ListViewHolder extends BaseViewHolder {
    public TextView text;
    public LinearLayout item;




    public ListViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void initView(View itemView) {
        text=(TextView)itemView.findViewById(R.id.text);
        item=(LinearLayout)itemView.findViewById(R.id.item);
    }
}
