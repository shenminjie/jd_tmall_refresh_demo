package ff_wms_rf.feifanzhixing.com.ffdmcpulltorefreshdemo.jd;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 *仿京东下拉刷新
 * Created by shenminjie on 2016/12/6.
 */

public class JdRefreshLayout extends PtrFrameLayout {

    /**
     * headerView
     */
     JdRefreshHeader mHeaderView;

    public JdRefreshLayout(Context context) {
        super(context);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }


    /**
     * 初始化view
     */
    private void initView() {
        mHeaderView = new JdRefreshHeader(getContext());
        setHeaderView(mHeaderView);
        addPtrUIHandler(mHeaderView);
    }


}
