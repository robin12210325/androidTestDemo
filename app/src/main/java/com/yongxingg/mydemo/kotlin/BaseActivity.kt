package com.yongxingg.mydemo.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by gaoyongxing on 2019-1-22.
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
    }
    abstract fun layoutId():Int
    abstract fun initView():Unit



}