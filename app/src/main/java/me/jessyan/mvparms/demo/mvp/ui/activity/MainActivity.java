package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.ClassDetail;
import me.jessyan.mvparms.demo.mvp.ui.adapter.MainAdapter;

/**
 * ================================================
 * 主页面(MVC) 逻辑很简单不需要Presenter，也不能用Daager2注入。
 * 因为BaseActivity里有个Presenter要注入，而MVC不能提供这个Presenter对象
 * <p>
 * Created by Sum41forever 2018/1/15
 * ================================================
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager mLayoutManager;
    MainAdapter mAdapter;
    List<ClassDetail> mClassList;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.main_activity;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        initRecyclerView();
        initAdapter();
        mRecyclerView.setAdapter(mAdapter);
        setAdapterOnItemClick();

    }

    private void initRecyclerView() {
        mLayoutManager = new GridLayoutManager(ArmsUtils.obtainAppComponentFromContext(getApplicationContext()).application(), 2);
        ArmsUtils.configRecyclerView(mRecyclerView, mLayoutManager);
    }

    private void initAdapter() {

        mClassList = new ArrayList<>();
        //  基本使用
        mClassList.add(new ClassDetail("Quick Use", UserActivity.class, "http://onro7cov0.bkt.clouddn.com/ic_jessyan.jpg"));
        //  复用Presenter
        mClassList.add(new ClassDetail("Use Multi Presenter", MultiPersenterActivity.class, "http://onro7cov0.bkt.clouddn.com/ic_sum41.png"));

        mAdapter = new MainAdapter(mClassList);
    }

    private void setAdapterOnItemClick() {

        mAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, View view, int position) {

                ClassDetail classDetail = (ClassDetail) mAdapter.getItem(position);
                if (classDetail != null && classDetail.getActivityClass() != null) {

                    startActivity(new Intent(getBaseContext(),
                            classDetail.getActivityClass()));
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        //super.onDestroy()之后会unbind,所有view被置为null,所以必须在之前调用
        DefaultAdapter.releaseAllHolder(mRecyclerView);
        super.onDestroy();
    }
}
