package atguigu.chenjiangfeng.homefragment;

import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.base.BaseFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class HomeFragment extends BaseFragment {
    ListView listview;
    @InjectView(R.id.pull_refresh_list)
    PullToRefreshListView pullRefreshList;

    @Override
    public View iniView() {
        View view = View.inflate(mContext, R.layout.fragment_home_main, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
