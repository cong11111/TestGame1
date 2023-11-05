package com.example.myapplication.setting

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val aboutFragment = AboutFragment()
        addFragmentInternal(aboutFragment, AboutFragment.TAG)
    }

   private fun addFragmentInternal(fragment: BaseFragment?, tag: String?) {
        if (fragment != null) {
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.container_terms, fragment, tag)
            beginTransaction.addToBackStack(tag)
            beginTransaction.commitAllowingStateLoss()
        }
    }
}