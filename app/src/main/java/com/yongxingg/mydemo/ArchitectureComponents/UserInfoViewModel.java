package com.yongxingg.mydemo.ArchitectureComponents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by gaoyongxing on 2018-11-12.
 */
public class UserInfoViewModel extends ViewModel {
    private String userId;
    private String name;
    private String password;
    private LiveData<ViewModel> user;

}
