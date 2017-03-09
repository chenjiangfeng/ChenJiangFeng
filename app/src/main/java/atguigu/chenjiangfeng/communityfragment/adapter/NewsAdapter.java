package atguigu.chenjiangfeng.communityfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import atguigu.chenjiangfeng.R;
import atguigu.chenjiangfeng.communityfragment.bean.NewPostBean;
import atguigu.chenjiangfeng.utils.Constants;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 陈江峰 on 2017/3/9.
 */

public class NewsAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<NewPostBean.ResultBean> datas;

    public NewsAdapter(Context mContext, List<NewPostBean.ResultBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.new_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置数据
        Glide.with(mContext).load(Constants.BASE_URL_IMAGE+datas.get(position).getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.ALL)

                .into(viewHolder.ibNewPostAvatar);
        Glide.with(mContext).load(Constants.BASE_URL_IMAGE+datas.get(position).getFigure())
                .diskCacheStrategy(DiskCacheStrategy.ALL)

                .into(viewHolder.ivCommunityFigure);
        viewHolder.tvCommunityUsername.setText(datas.get(position).getUsername());
        viewHolder.tvCommunitySaying.setText(datas.get(position).getSaying());
        viewHolder.tvCommunityLikes.setText(datas.get(position).getLikes());
        viewHolder.tvCommunityComments.setText(datas.get(position).getComments());

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.tv_community_username)
        TextView tvCommunityUsername;
        @InjectView(R.id.tv_community_addtime)
        TextView tvCommunityAddtime;
        @InjectView(R.id.rl)
        RelativeLayout rl;
        @InjectView(R.id.ib_new_post_avatar)
        ImageButton ibNewPostAvatar;
        @InjectView(R.id.iv_community_figure)
        ImageView ivCommunityFigure;
        @InjectView(R.id.tv_community_saying)
        TextView tvCommunitySaying;
        @InjectView(R.id.tv_community_likes)
        TextView tvCommunityLikes;
        @InjectView(R.id.tv_community_comments)
        TextView tvCommunityComments;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
