// -*- Mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
//
// Copyright (C) 2015 Testin.  All rights reserved.
//
// This file is an original work developed by Testin

package com.testin.apm.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// import com.testin.agent.TestinAgent;

/**
 * This application is use to test Testin Apm
 */
public class MainActivity extends Activity {
    public Button mHttpClientTestBtn;
    public Button mHttpUrlConnectionTestBtn;
    public Button mSqliteTestBtn;
    public Button mBitmapTestBtn;
    public Button mGsonTestBtn;
    public Button mFragmentTestBtn;
    public Button mWebviewTestBtn;
    public Button mTabWebviewTestBtn;
    public Button mUrlReportTestBtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();
    }

    private void init() {
        OnClickListener l = new ButtonListener();
        mHttpClientTestBtn = (Button) findViewById(R.id.http_client_test_btn);
        mHttpClientTestBtn.setOnClickListener(l);

        mHttpUrlConnectionTestBtn = (Button) findViewById(R.id.http_url_connection_test_btn);
        mHttpUrlConnectionTestBtn.setOnClickListener(l);

        mSqliteTestBtn = (Button) findViewById(R.id.sqlite_test_btn);
        mSqliteTestBtn.setOnClickListener(l);

        mBitmapTestBtn = (Button) findViewById(R.id.bitmap_test_btn);
        mBitmapTestBtn.setOnClickListener(l);

        mGsonTestBtn = (Button) findViewById(R.id.gson_test_btn);
        mGsonTestBtn.setOnClickListener(l);

        mFragmentTestBtn = (Button) findViewById(R.id.fragment_test_btn);
        mFragmentTestBtn.setOnClickListener(l);

        mWebviewTestBtn = (Button) findViewById(R.id.webview_test_btn);
        mWebviewTestBtn.setOnClickListener(l);

        mTabWebviewTestBtn = (Button) findViewById(R.id.tab_webview_test_btn);
        mTabWebviewTestBtn.setOnClickListener(l);

        mUrlReportTestBtn = (Button) findViewById(R.id.url_report_test_btn);
        mUrlReportTestBtn.setOnClickListener(l);

        // Add TestinAgent initialization here
        // TestinAgent.init(this, "19f0d1d1b0a7637d34987c7debd98a91");
    }

    class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            boolean testable = true;
            Intent intent = new Intent();

            switch (v.getId()) {
                case R.id.http_client_test_btn:
                    intent.setClass(MainActivity.this, HttpTestActivity.class);
                    intent.putExtra(Config.TEST_TYPE_KEY, Config.TYPE_HTTP_CLIENT);
                    break;
                case R.id.http_url_connection_test_btn:
                    intent.setClass(MainActivity.this, HttpTestActivity.class);
                    intent.putExtra(Config.TEST_TYPE_KEY, Config.TYPE_HTTP_URL);
                    break;
                case R.id.sqlite_test_btn:
                    intent.setClass(MainActivity.this, SqliteTestActivity.class);
                    break;
                case R.id.bitmap_test_btn:
                    intent.setClass(MainActivity.this, BitmapTestActivity.class);
                    break;
                case R.id.gson_test_btn:
                    intent.setClass(MainActivity.this, GsonTestActivity.class);
                    break;
                case R.id.fragment_test_btn:
                    intent.setClass(MainActivity.this, FragmentTestActivity.class);
                    break;
                case R.id.webview_test_btn:
                    intent.setClass(MainActivity.this, WebviewTestActivity.class);
                    break;
                case R.id.tab_webview_test_btn:
                    intent.setClass(MainActivity.this, TabWebViewActivity.class);
                    break;
                case R.id.url_report_test_btn:
                    intent.setClass(MainActivity.this, UrlReportActivity.class);
                    break;
                default:
                    testable = false;
                    break;
            }

            if (testable) {
                startActivity(intent);
            }
        }
    }
}
