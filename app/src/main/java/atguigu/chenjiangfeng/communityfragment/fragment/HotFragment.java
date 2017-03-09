package atguigu.chenjiangfeng.communityfragment.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.base.BaseFragment;
import atguigu.chenjiangfeng.communityfragment.adapter.HotPostListViewAdapter;
import atguigu.chenjiangfeng.communityfragment.bean.HotPostBean;
import atguigu.chenjiangfeng.utils.Constants;
import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class HotFragment extends BaseFragment {
    @InjectView(R.id.community_hot)
    RecyclerView communityHot;
    private HotPostListViewAdapter adapter;

    @Override
    public View iniView() {
        View view = View.inflate(mContext, R.layout.fragment_community_hot, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getFromNet();
    }


    private void getFromNet() {
        OkHttpUtils.get().url(Constants.HOT_POST_URL)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(mContext, "请求数据失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
//                    Toast.makeText(context,"请求数据成功"+response,Toast.LENGTH_SHORT).show();
                //解析数据
                analyticalData(response);
            }
        });
    }

    private void analyticalData(String response) {
        HotPostBean bean = JSON.parseObject(response, HotPostBean.class);
//        Toast.makeText(mContext,""+ bean.getResult().get(1).getUsername(),Toast.LENGTH_SHORT).show();
        List<HotPostBean.ResultBean> result = bean.getResult();
        if (result != null && result.size() > 0) {
            //设置适配器
            adapter = new HotPostListViewAdapter(mContext, result);
            communityHot.setAdapter(adapter);

            communityHot.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
