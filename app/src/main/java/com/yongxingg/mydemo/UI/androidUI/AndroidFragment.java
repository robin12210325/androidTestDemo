package com.yongxingg.mydemo.UI.androidUI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yongxingg.mydemo.R;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public class AndroidFragment extends Fragment implements AndroidContracts.View{
    public static final String pageCount = "10";
    public static final int pageNum = 1;
    private AndroidContracts.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;
    private AndroidRecycleViewAdapter myRecycleViewAdapter;
    public static AndroidFragment newInstance(String info) {
        Bundle args = new Bundle();
        AndroidFragment fragment = new AndroidFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_android_fragment,container,false);
        String info = getArguments().getString("info");
        initData(view);
        return view;
    }

    private void initData(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.androidList);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.androidSwipeFresh);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        myRecycleViewAdapter = new AndroidRecycleViewAdapter(this.getActivity());
        mRecyclerView.setAdapter(myRecycleViewAdapter);
        mPresenter = new AndroidPresenter(this);
        getData(pageNum);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(pageNum);
            }
        });
    }
    //获取数据
    private void getData(int pageNum){
        if (!mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(true);
        }
        if (null != mPresenter){
            mPresenter.getAndroidData(pageCount,pageNum);
        }
    }

    @Override
    public void showDialog() {

        System.out.println("androidFragent=startShowDialog");
    }

    @Override
    public void dismissDialog() {
        System.out.println("androidFragent=endShowDialog");
    }

    @Override
    public void setPresenter(AndroidContracts.Presenter presenter) {
        if (null != presenter){
            this.mPresenter = presenter;
        }


    }

    @Override
    public void showData(AndroidModel string) {
        System.out.println("androidFragent=" + string.getResults().get(0).getDesc());
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
        myRecycleViewAdapter.setLists(string.getResults());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mPresenter){
            mPresenter.onDestory();
            mPresenter = null;
        }
    }
}
