package ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.jd;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;



import java.util.ArrayList;
import java.util.List;

import ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.MyAdapter;
import ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.R;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class JdActivity extends AppCompatActivity {
    /**
     * 列表
     */
     RecyclerView mRecyclerView;

    /**
     * 下拉刷新
     */
    JdRefreshLayout mLayout;

    /**
     * 布局管理器
     */
     RecyclerView.LayoutManager mManager;

    /**
     * 数据
     */
    private List<Object> mDatas;

    /**
     * 适配器
     */
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDatas=new ArrayList<>();
        for(int i=0;i<5;i++){
            mDatas.add(new Object());
        }

        mLayout = (JdRefreshLayout) findViewById(R.id.test_recycler_view_frame);
        mRecyclerView = (RecyclerView) findViewById(R.id.test_recycler_view);
        mManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter=new MyAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                doSth();
            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    /**
     * demo
     */
    private void doSth() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mDatas.add(new Object());
                mAdapter.notifyDataSetChanged();
                mLayout.refreshComplete();
            }
        }.execute();
    }

}
