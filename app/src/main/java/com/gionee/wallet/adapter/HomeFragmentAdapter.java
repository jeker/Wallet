package com.gionee.wallet.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.gionee.wallet.R;
import com.gionee.wallet.model.bean.response.HomeFragmentBean;
import com.gionee.wallet.model.bean.response.ServicesListResponse;
import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.adapter.MultiItemTypeAdapter;
import com.zhxu.recyclerview.base.ItemViewDelegate;
import com.zhxu.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by jeker on 2018/1/8.
 * <p>
 */

public class HomeFragmentAdapter extends MultiItemTypeAdapter<HomeFragmentBean.ServiceBean> {

    private Context mContext;
    private OnItemClickListenter mlistener;

    /**
     * 给Recommend调用的接口回调 具体处理交给调用者
     */
    public interface OnItemClickListenter {
        void goDetailActivity(String packageName);
    }

    public void setOnItemClickListenter(OnItemClickListenter listener) {
        this.mlistener = listener;
    }

    public HomeFragmentAdapter(Context context, List<HomeFragmentBean.ServiceBean> datas) {
        super(context, datas);
        this.mContext = context;

        addItemViewDelegate(new AdItemDelegate());
        addItemViewDelegate(new AppItemDelegate());
    }


    /**
     * 推荐适配器
     */
    public class AdItemDelegate implements ItemViewDelegate<HomeFragmentBean.ServiceBean> {

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_rencommend;
        }

        @Override
        public boolean isForViewType(HomeFragmentBean.ServiceBean item, int position) {
            return item.getType() == 0;
        }

        @Override
        public void convert(ViewHolder holder, HomeFragmentBean.ServiceBean item, int position) {

            holder.setImageUrl(mContext,R.id.icon, item.getTopList().get(0).getServiceIconUrl());
            holder.setText(R.id.channel_name, item.getTopList().get(0).getServiceName());
            holder.setImageUrl(mContext,R.id.icon2, item.getTopList().get(1).getServiceIconUrl());
            holder.setText(R.id.channel_name2, item.getTopList().get(0).getServiceName());
            holder.setOnClickListener(R.id.icon, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "暂无数据(0)", Toast.LENGTH_SHORT).show();
                }
            });
            holder.setOnClickListener(R.id.icon2, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "暂无数据(1)", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * service条目的适配器
     */
    public class AppItemDelegate implements ItemViewDelegate<HomeFragmentBean.ServiceBean> {
        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_applist_horizontal;
        }

        @Override
        public boolean isForViewType(HomeFragmentBean.ServiceBean item, int position) {
            return item.getType() == 1;
        }

        @Override
        public void convert(ViewHolder holder, final HomeFragmentBean.ServiceBean recommendAppBean, int position) {
            RecyclerView recyclerView = holder.getView(R.id.rv_applist_item);
            GridLayoutManager mGridLayoutManager = new GridLayoutManager(mContext, 3);
//            mGridLayoutManager.setSpanSizeLookup(new SectionedSpanSizeLookup(mAdapter,
//                    mGridLayoutManager));
            recyclerView.setLayoutManager(mGridLayoutManager);

            ServiceItemAdapter adapter = new ServiceItemAdapter(mContext);
            adapter.addDataAll(recommendAppBean.getServerList());
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                  //  String packageName = recommendAppBean.getServerList().get(position).getPackageName();
                    mlistener.goDetailActivity("");
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                    return false;
                }
            });

        }
    }

    private class ServiceItemAdapter extends CommonAdapter<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> {

        public ServiceItemAdapter(Context context) {
            super(context, R.layout.item_service);
        }

        @Override
        protected void convert(ViewHolder holder, ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList appBean, int position) {
            holder.setImageUrl(mContext,R.id.icon, appBean.getServiceIconUrl());
            holder.setText(R.id.channel_name, appBean.getServiceName());
        }
    }

}
