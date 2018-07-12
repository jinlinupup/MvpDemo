package com.jinlin.mvpdemo.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ****************************************************
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>万能Adapter基类</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-6-1 下午1:06:36</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>SHLD</dd>
 *
 * @author aa1000777 - Email:aa1000777@qq.com
 *         ****************************************************
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    public void updateListView(List<T> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public void updateListView2(List<T> list) {
        this.mDatas = list;
    }

    @Override
    public int getCount() {
        if (mDatas.size() != 0) {
            return mDatas.size();
        } else {
            return 0;
        }
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder helper, T item, int position);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
    }

}
