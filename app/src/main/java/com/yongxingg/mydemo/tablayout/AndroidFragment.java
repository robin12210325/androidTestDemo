package com.yongxingg.mydemo.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yongxingg.mydemo.R;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public class AndroidFragment extends Fragment {
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
        return view;
    }
}
