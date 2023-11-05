package com.example.myapplication.setting

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.base.BaseFragment


abstract class BaseActivity : AppCompatActivity() {

    fun toFragment(fragment: BaseFragment?) {
        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction() // 开启一个事务
            transaction.replace(getFragmentContainerRes(), fragment)
            transaction.commitAllowingStateLoss()
        }
    }

    @IdRes
    protected open fun getFragmentContainerRes(): Int {
//        return R.id.fl_sign_up_container
        return -1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
//        AppManager.sInstance.addActivity(this)
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    fun addFragment(fragment: BaseFragment?, tag: String?) {
        if (fragment != null) {
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(getFragmentContainerRes(), fragment, tag)
            beginTransaction.addToBackStack(tag)
            beginTransaction.commitAllowingStateLoss()
        }
    }

    open fun useLogout(): Boolean {
        return false
    }
}