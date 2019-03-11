package com.yongxingg.mydemo.UI.androidUI;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yongxingg.mydemo.R;
import com.yongxingg.mydemo.animView.DefaultAnimations;
import com.yongxingg.mydemo.animView.DefaultSort;
import com.yongxingg.mydemo.animView.Spruce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public class AndroidFragment extends Fragment implements AndroidContracts.View{
    public static final String pageCount = "10";
    public static int pageNum = 1;
    private AndroidContracts.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;
    private AndroidRecycleViewAdapter myRecycleViewAdapter;
    List<AndroidModel.ResultsBean> beans = new ArrayList<>();

    private Animator spruceAnimator;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
//                initSpruce();
            }
        };
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myRecycleViewAdapter = new AndroidRecycleViewAdapter(this.getActivity());
        mRecyclerView.setAdapter(myRecycleViewAdapter);
        mPresenter = new AndroidPresenter(this);
        getLifecycle().addObserver(mPresenter);
        getData(pageNum);
//        initSpruce();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                beans.clear();
                getData(pageNum);
            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = recyclerView.getAdapter().getItemCount();
                int lastVisibleItemPosition = lm.findLastVisibleItemPosition();
                int visibleItemCount = recyclerView.getChildCount();

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition == totalItemCount - 1
                        && visibleItemCount > 0) {
                    //加载更多
                    pageNum ++;
                    getData(pageNum);
                }

            }
        });
    }
    private void initSpruce() {
        spruceAnimator = new Spruce.SpruceBuilder(mRecyclerView)
                .sortWith(new DefaultSort(100))
                .animateWith(DefaultAnimations.shrinkAnimator(mRecyclerView, 800),
                        ObjectAnimator.ofFloat(mRecyclerView, "translationX", -mRecyclerView.getWidth(), 0f).setDuration(800))
                .start();
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
        if (pageNum == 1){
            beans.addAll(string.getResults());
            beans = string.getResults();
        }else {
            beans.addAll(string.getResults());
        }
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
        myRecycleViewAdapter.setLists(beans);
    }


    /**
     * 如果采用lifecycle的话 就不需要在view中通知presenter的ondestory了
     * presenter可以自动根据activity的生命周期同步
     */
   /* @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mPresenter){
            mPresenter.onDestory();
            mPresenter = null;
        }
    }*/
}
