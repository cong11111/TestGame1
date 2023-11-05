package com.example.myapplication.setting

import android.os.Bundle
import android.os.SystemClock
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment

class WebViewFragment : BaseFragment() {
    private var webView: WebView? = null

    private var mUrl: String? = null
    private var pbLoading: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_webview, container, false)
        initializeView(view)
        initializeData()
        return view
    }

    private fun initializeView(view: View) {
        pbLoading = view.findViewById<ProgressBar>(R.id.pb_webview_loading)
        webView = view.findViewById<WebView>(R.id.web_view)
//        startLoading();
    }

    private fun initializeData() {
        webView!!.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress > 100 && pbLoading == null) {
                    return
                }
                if (newProgress == 100) {
                    if (pbLoading!!.visibility == View.VISIBLE) {
                        pbLoading!!.visibility = View.GONE
                    }
                } else {
                    if (pbLoading!!.visibility != View.VISIBLE) {
                        pbLoading!!.visibility = View.VISIBLE
                    }
                    pbLoading!!.progress = newProgress
                }
                //                Log.e("Test", " on progress changed = " + newProgress);
            }
        }
        webView!!.webViewClient = webViewClient
        webView!!.settings.javaScriptEnabled = true
        if (!TextUtils.isEmpty(mUrl)) {
            webView!!.loadUrl(mUrl!!)
            //            Log.e("Test", " url 1 = " + mUrl);
        }
    }

    private val webViewClient: WebViewClient = object : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
        }
    }

    fun setUrl(url: String?) {
        mUrl = url
        if (webView != null) {
            webView!!.loadUrl(mUrl!!)
            Log.e("Test", " url = $mUrl")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mUrl = null
    }

    override fun onDestroy() {
        super.onDestroy()
        if (webView != null) {
            webView!!.destroy()
        }
    }

    private fun startLoading() {
        object : Thread() {
            override fun run() {
                super.run()
                for (i in 0..99) {
                    SystemClock.sleep(500)
                    activity!!.runOnUiThread {
                        if (pbLoading != null) {
                            pbLoading!!.progress = i
                        }
                    }
                }
            }
        }.start()
    }
}