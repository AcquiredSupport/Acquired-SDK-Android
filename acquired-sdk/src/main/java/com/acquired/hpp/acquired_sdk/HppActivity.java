package com.acquired.hpp.acquired_sdk;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Copyright (c) 2018 @Acquired
 * <p>
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 * <p>
 * Created by Leo on 07/08/2018.
 */
public class HppActivity extends AppCompatActivity {
    private WebView hpp_WebView;
    private ProgressBar hpp_ProgressBar;
    private String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hpp);
        hpp_ProgressBar = (ProgressBar) findViewById(R.id.com_acquired_hpp_progressbar);

        this.setWebView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("acquired_hpp", "if it's previous page:" + hpp_WebView.canGoBack());
        if (hpp_WebView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {
            hpp_WebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("JavascriptInterface")
    private void setWebView() {
        hpp_WebView = (WebView) findViewById(R.id.com_acquired_hpp_webview);


        hpp_WebView.addJavascriptInterface(this, "android");
        hpp_WebView.setWebChromeClient(webChromeClient);
        hpp_WebView.setWebViewClient(webViewClient);

        WebSettings webSettings = hpp_WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//enable javascript

        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setSupportZoom(false);//disable zoom
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);//hide webview zoom button

//        webSettings.setLoadWithOverviewMode(true);//auto fit screen
//        webSettings.setUseWideViewPort(true);

        try {
            Intent intent = getIntent();
            this.url = intent.getStringExtra("HPPURL");
            hpp_WebView.loadUrl(this.url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            hpp_ProgressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            hpp_ProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
//            if (request.getUrl().toString().equals(this.url)) {
//            }
        }

    };

    private WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("Confirm", null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();

            result.confirm();
            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            AlertDialog.Builder b = new AlertDialog.Builder(view.getContext());
//            b.setTitle("Confirm");
            b.setMessage(message);
            final JsResult jsResult = result;
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    jsResult.confirm();
                }
            });
            b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    jsResult.cancel();
                }
            });
            AlertDialog ad = b.create();
            ad.setCanceledOnTouchOutside(false);
            ad.show();
            return true;
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            Log.i("acquired_hpp", "APP Title:" + title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            hpp_ProgressBar.setProgress(newProgress);
        }
    };


    @JavascriptInterface
    public void getClient(String str) {
        Log.i("acquired_hpp", "call client html:" + str);
    }

    @Override
    protected void onDestroy() {
        if (hpp_WebView != null) {
            hpp_WebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            hpp_WebView.clearHistory();
            ((ViewGroup) hpp_WebView.getParent()).removeView(hpp_WebView);
            hpp_WebView.destroy();
            hpp_WebView = null;
        }

        super.onDestroy();
    }

}
