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
package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.ClassDetail;

/**
 * ================================================
 * 展示 {@link BaseHolder} 的用法
 * <p>
 * Created by Sum41forever on 01/13/2018
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class MainItemHolder extends BaseHolder<ClassDetail> {

    @BindView(R.id.iv_avatar)
    ImageView mAvatar;
    @BindView(R.id.tv_name)
    TextView mName;

    public MainItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(ClassDetail data, int position) {

        mName.setText(TextUtils.isEmpty(data.getTitle()) ? "" : data.getTitle());

        if ( data.getAvatarUrl() != null) {
            mAvatar.setImageResource(data.getAvatarUrl());
        }
    }

}
