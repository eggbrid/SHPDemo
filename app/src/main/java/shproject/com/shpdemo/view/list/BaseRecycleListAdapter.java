package shproject.com.shpdemo.view.list;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xus on 2017/3/22.
 */

public abstract class BaseRecycleListAdapter<V extends BaseViewHolder> extends RecyclerView.Adapter<V> {
    protected Context context;
   public BaseRecycleListAdapter(Context context){
        this.context=context;
    }
    public abstract int setItemLayoutId();
    public abstract V setViewHolder(View v);

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        return setViewHolder(LayoutInflater.from(context).inflate(setItemLayoutId(),parent,false));
    }



}
