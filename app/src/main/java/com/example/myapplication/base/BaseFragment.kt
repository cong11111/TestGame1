package com.example.myapplication.base

import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.ToastUtils

open class BaseFragment : Fragment() {


    private var lastClickMillions: Long = 0

    protected fun checkClickFast(): Boolean {
        return checkClickFast(true)
    }

    protected fun checkClickFast(showFlag : Boolean): Boolean {
        val delay = System.currentTimeMillis() - lastClickMillions
        if (delay < 3000) {
            if (showFlag) {
                ToastUtils.showShort("Click too fast, please try again later")
            }
            return true
        }
        lastClickMillions = System.currentTimeMillis()
        return false
    }

    protected fun checkShortClickFast(): Boolean {
        val delay = System.currentTimeMillis() - lastClickMillions
        if (delay < 500) {
            ToastUtils.showShort("Click too fast, please try again later")
            return true
        }
        lastClickMillions = System.currentTimeMillis()
        return false
    }

    protected fun isDestroy() : Boolean{
        if (activity == null || activity?.isFinishing == true || activity?.isDestroyed == true) {
            return true
        }
        if (isDetached || isRemoving || !isAdded){
            return true
        }
        return false
    }
}