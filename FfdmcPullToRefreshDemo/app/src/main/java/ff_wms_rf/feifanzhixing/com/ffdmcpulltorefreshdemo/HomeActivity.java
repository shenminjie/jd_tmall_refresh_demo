package ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.jd.JdActivity;
import ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.tmall.TmallActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.btn_jd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(JdActivity.class);
            }
        });
        findViewById(R.id.btn_tmall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(TmallActivity.class);
            }
        });
    }

    /**
     * 跳转
     *
     * @param cl
     */
    public void toActivity(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }

}
