package shproject.com.shpdemo.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xus on 2017/3/22.
 */

/**
 * 为了方便创建ViewHolder
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }
    public abstract void initView(View itemView);
}
