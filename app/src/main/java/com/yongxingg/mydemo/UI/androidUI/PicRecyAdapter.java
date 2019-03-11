package com.yongxingg.mydemo.UI.androidUI;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yongxingg.mydemo.R;

import java.util.List;

/**
 * Created by gaoyongxing on 2018-3-30.
 */
public class PicRecyAdapter extends RecyclerView.Adapter<PicRecyAdapter.PicViewHolder> {
    Context mContext;
    private List<String> datas;
    String orderNum;

    public PicRecyAdapter(Context mContext, List<String> images) {
        this.mContext = mContext;
        this.datas = images;
    }

    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pic_item, parent, false);

        final PicViewHolder holder = new PicViewHolder(view);

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EventBus.getDefault().post(orderNum, EventTag.transInToCarGoListDetail);
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(PicViewHolder holder, int position) {

        Glide.with(mContext).load(datas.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return datas == null?0:datas.size();
    }

    static class PicViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public PicViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.android_pic);
        }
    }
}
