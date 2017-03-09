package atguigu.chenjiangfeng.communityfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import atguigu.chenjiangfeng.base.BaseFragment;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class CommunityAdapter extends FragmentPagerAdapter {
    private final FragmentManager ft;
    private final List<BaseFragment> datas;
    private String[] titles = new String[]{"新帖", "热帖"};

    public CommunityAdapter(FragmentManager ft, List<BaseFragment> datas) {
        super(ft);
        this.ft =ft;
        this.datas =datas;
    }
    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
