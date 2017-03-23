package shproject.com.shpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import shproject.com.shpdemo.mvp.activitys.BookListActivity;
import shproject.com.shpdemo.view.list.demo.RecyclerListViewActivity;

public class MainActivity extends AppCompatActivity {

    protected ListView list;
    private MainAdapter adapter;
    private List<MainBean> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        list = (ListView) findViewById(R.id.list);
        adapter = new MainAdapter(this);
        lists.add(new MainBean("RecyclerListView类似listview的RecyclerView", RecyclerListViewActivity.class));
        lists.add(new MainBean("mvp 项目实例", BookListActivity.class));

        adapter.setList(lists);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,lists.get(i).getaClass());
                startActivity(intent);
            }
        });
    }
}
