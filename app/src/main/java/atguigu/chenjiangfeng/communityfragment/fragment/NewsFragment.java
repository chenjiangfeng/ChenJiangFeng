package atguigu.chenjiangfeng.communityfragment.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.base.BaseFragment;
import atguigu.chenjiangfeng.communityfragment.adapter.NewsAdapter;
import atguigu.chenjiangfeng.communityfragment.bean.NewPostBean;
import atguigu.chenjiangfeng.utils.Constants;
import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class NewsFragment extends BaseFragment {
    @InjectView(R.id.listview)
    ListView listview;

    @Override
    public View iniView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //联网请求数据
        getDataFromeNet();
    }

    private void getDataFromeNet() {
        OkHttpUtils.get().url(Constants.NEW_POST_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(mContext, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
//                Toast.makeText(mContext,"请求成功"+response,Toast.LENGTH_SHORT).show();
                analyticalData(response);
            }
        });
    }

    private void analyticalData(String response) {
        NewPostBean bean = JSON.parseObject(response, NewPostBean.class);

//        Toast.makeText(mContext,""+bean.getResult().get(0).getFigure(),Toast.LENGTH_SHORT).show();
        //设置适配器

        List<NewPostBean.ResultBean> datas = bean.getResult();
        if(datas!=null&&datas.size()>0) {
            NewsAdapter adapter = new NewsAdapter(mContext, datas);
            listview.setAdapter(adapter);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
