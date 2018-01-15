/**
 * Copyright 2017 JessYan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.ClassDetail;
import me.jessyan.mvparms.demo.mvp.ui.holder.MainItemHolder;

/**
 * ================================================
 * 展示 {@link DefaultAdapter} 的用法
 * <p>
 * Created by Sum41forever on 01/13/2018
 * <a href="http://www.sum41forever.com/">My Blog</a>
 * <a href="https://github.com/sum41forever">My github</a>
 * ================================================
 */
public class MainAdapter extends DefaultAdapter<ClassDetail> {

    private OnItemClickListener mOnItemClickListener;


    public MainAdapter(List<ClassDetail> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<ClassDetail> getHolder(View view, int viewType) {

        BaseHolder<ClassDetail> holder =  new MainItemHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder, view, holder.getAdapterPosition());
                }
            }
        });

        return holder;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_view;
    }

    @Override
    public ClassDetail getItem(int position) {
        return mInfos.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(RecyclerView.ViewHolder holder, View view, int position);
    }

}
