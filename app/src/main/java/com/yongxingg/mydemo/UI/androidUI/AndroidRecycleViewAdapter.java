package com.yongxingg.mydemo.UI.androidUI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yongxingg.mydemo.R;
import com.yongxingg.mydemo.view.MyRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public class AndroidRecycleViewAdapter extends RecyclerView.Adapter<AndroidRecycleViewAdapter.ViewHolder>{
    private Context mContext;
    private List<AndroidModel.ResultsBean> list = new ArrayList<>();
    PicRecyAdapter picRecyAdapter;
    LinearLayoutManager linearLayoutManager;
    public AndroidRecycleViewAdapter(Context mContext){
        this.mContext = mContext;
        linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    }
    public void setLists(List<AndroidModel.ResultsBean> datas){
        list.clear();
        this.list.addAll(datas);
        System.out.println("androidFragentData=" + list.size() + "//" + String.valueOf(list));
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_android_fragment_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.androidPublishedAt.setText(list.get(i).getPublishedAt());
        viewHolder.androidDesc.setText(list.get(i).getDesc());
        viewHolder.androidUrl.setText(list.get(i).getUrl());
        linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.myRecycleView.setLayoutManager(linearLayoutManager);

        picRecyAdapter = new PicRecyAdapter(mContext, list.get(i).getImages());
        viewHolder.myRecycleView.setAdapter(picRecyAdapter);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView androidPublishedAt,androidDesc,androidUrl;
        private MyRecycleView myRecycleView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            androidPublishedAt = (TextView) itemView.findViewById(R.id.androidPublishedAt);
            androidDesc = (TextView) itemView.findViewById(R.id.androidDesc);
            androidUrl = (TextView) itemView.findViewById(R.id.androidUrl);
            myRecycleView = (MyRecycleView) itemView.findViewById(R.id.androidPicMyRecycleView);
        }
    }
    public OnItemClickListener itemClickListener;
    public  void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
