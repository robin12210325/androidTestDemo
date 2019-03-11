package com.yongxingg.mydemo.kotlin

import com.yongxingg.mydemo.R
import kotlinx.android.synthetic.main.activity_main_kotlin.*

class MainKotlinActivity : BaseActivity() {
    override fun layoutId(): Int {
       return R.layout.activity_main_kotlin
    }

    override fun initView() {
        myText.setText("nihao")
    }

}
