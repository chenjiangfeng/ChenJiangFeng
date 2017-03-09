package atguigu.chenjiangfeng.communityfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.communityfragment.bean.HotPostBean;
import atguigu.chenjiangfeng.utils.Constants;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class HotPostListViewAdapter extends RecyclerView.Adapter<HotPostListViewAdapter.ViewHolder> {

    private final List<HotPostBean.ResultBean> datas;
    private final Context mContext;


    public HotPostListViewAdapter(Context mContext, List<HotPostBean.ResultBean> result) {
        this.mContext = mContext;
        this.datas = result;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.hot_item, null));
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //设置适配器
        HotPostBean.ResultBean bean = datas.get(position);


        Glide.with(mContext)
                .load(Constants.BASE_URL_IMAGE + bean.getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.log)
                .error(R.drawable.log)
                .into(holder.ivNewPostAvatar);

        holder.tvHotUsername.setText(bean.getUsername());

        Glide.with(mContext)
                .load(Constants.BASE_URL_IMAGE + bean.getFigure())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.log)
                .error(R.drawable.log)
                .into(holder.ivHotFigure);

        holder.tvHotSaying.setText(bean.getSaying());
        holder.tvHotLikes.setText(bean.getIs_like());
        holder.tvHotComments.setText(bean.getComments());
//        String istop = bean.getIs_top();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

  class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tv_hot_username)
        TextView tvHotUsername;
        @InjectView(R.id.tv_hot_addtime)
        TextView tvHotAddtime;
        @InjectView(R.id.rl)
        RelativeLayout rl;
        @InjectView(R.id.iv_new_post_avatar)
        ImageView ivNewPostAvatar;
        @InjectView(R.id.iv_hot_figure)
        ImageView ivHotFigure;
        @InjectView(R.id.ll_hot_post)
        LinearLayout llHotPost;
        @InjectView(R.id.tv_hot_saying)
        TextView tvHotSaying;
        @InjectView(R.id.tv_hot_likes)
        TextView tvHotLikes;
        @InjectView(R.id.tv_hot_comments)
        TextView tvHotComments;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
}
