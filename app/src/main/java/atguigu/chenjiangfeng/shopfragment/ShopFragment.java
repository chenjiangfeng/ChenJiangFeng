package atguigu.chenjiangfeng.shopfragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import atguigu.chenjiangfeng.base.BaseFragment;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class ShopFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View iniView() {
//        View view = View.inflate(mContext, R.layout.fragment_home,null);
        textView =new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("购物");
    }
}
