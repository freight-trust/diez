package org.diez.haiku

import org.diez.file.File
import android.annotation.SuppressLint
import android.graphics.Color
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.FrameLayout

data class Haiku(val component: String) {
    private fun file(): File {
        return File("/haiku/$component")
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun embedHaiku(view: ViewGroup) {
        val webview = WebView(view.context)
        webview.setBackgroundColor(Color.TRANSPARENT)
        webview.isVerticalScrollBarEnabled = false
        webview.isHorizontalScrollBarEnabled = false
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(file().canonicalURL())
        view.addView(webview)
        webview.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
    }
}