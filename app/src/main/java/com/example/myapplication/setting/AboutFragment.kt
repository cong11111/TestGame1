package com.example.myapplication.setting

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import com.blankj.utilcode.util.AppUtils
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment

class AboutFragment : BaseFragment() {

    companion object {
        const val TAG = "AboutFragment"
        const val GET_POLICY: String = "https://www.creditng.com/privacy.html"

        const val GET_TERMS: String = "https://www.creditng.com/terms.html"
    }


    private var tvVersion: AppCompatTextView? = null
    private var llTerms: LinearLayout? = null
    private var llPrivacy: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_about, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvVersion = view.findViewById(R.id.tv_abount_version)
        var versionName = AppUtils.getAppVersionName()
        if (!TextUtils.isEmpty(versionName)) {
            tvVersion?.text = versionName
        }

        llTerms = view.findViewById(R.id.ll_about_terms)
        llPrivacy = view.findViewById(R.id.ll_about_privacy)

        llTerms?.setOnClickListener(View.OnClickListener {
            toWebView(GET_TERMS, WebViewActivity.TYPE_TERMS)
        })
        llPrivacy?.setOnClickListener(View.OnClickListener {
            toWebView(GET_POLICY, WebViewActivity.TYPE_PRIVACY)
        })
    }

    private fun toWebView(url: String, type: Int) {
        if (!isAdded || isRemoving || isDetached) {
            return
        }
        if (checkClickFast()) {
            return
        }
        WebViewActivity.launchWebView(requireContext(), url, type)
    }
}