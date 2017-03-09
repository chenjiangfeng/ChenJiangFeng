package atguigu.chenjiangfeng.communityfragment.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.base.BaseFragment;
import atguigu.chenjiangfeng.communityfragment.adapter.CommunityAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class CommunityFragment extends BaseFragment {

    @InjectView(R.id.iv_community)
    ImageView ivCommunity;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    private List<BaseFragment> datas;
    private CommunityAdapter adapter;

    @Override
    public View iniView() {
        View view = View.inflate(mContext, R.layout.fragment_community, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //数据
        getData();
        //设置适配器
        adapter = new CommunityAdapter(getFragmentManager(), datas);
        viewPager.setAdapter(adapter);
        //跟viewPager关联
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void getData() {
        datas = new ArrayList<>();
        datas.add(new NewsFragment());
        datas.add(new HotFragment());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.iv_community)
    public void onClick() {
    }


}
