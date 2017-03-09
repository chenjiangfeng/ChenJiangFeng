package atguigu.chenjiangfeng;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import atguigu.chenjiangfeng.base.BaseFragment;
import atguigu.chenjiangfeng.communityfragment.fragment.CommunityFragment;
import atguigu.chenjiangfeng.homefragment.HomeFragment;
import atguigu.chenjiangfeng.shopfragment.ShopFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    private List<BaseFragment>fragment;
    private  int position;
    /**
     * 缓存
     */
    private Fragment tempFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        listener();
    }

    private void listener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        position = 0 ;
                        break;
                    case R.id.rb_community:
                        position = 1 ;
                        break;
                    case R.id.rb_shop:
                        position = 2 ;
                        break;
                }
               Fragment currentFragment = fragment.get(position);
                switchFragment(currentFragment);
            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(Fragment currentFragment) {
        FragmentTransaction  ft = getSupportFragmentManager().beginTransaction();
        //切换不是同一个
        if(tempFragment!=currentFragment) {
            //没有添加过
            if(!currentFragment.isAdded()) {
                if(tempFragment!=null) {
                    ft.hide(tempFragment);

                }
                ft.add(R.id.fl_main,currentFragment);
            }else {//添加过
                if(tempFragment!=null) {
                    ft.hide(tempFragment);
                    ft.show(currentFragment);
                }
            }

        }else {//切换的是同一个
            ft.show(currentFragment);
        }
        ft.commit();
        tempFragment = currentFragment;
    }

    private void initData() {
        fragment = new ArrayList<>();
        fragment.add(new HomeFragment());
        fragment.add(new CommunityFragment());
        fragment.add(new ShopFragment());
    }
}
