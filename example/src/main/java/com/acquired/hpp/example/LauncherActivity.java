package com.acquired.hpp.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acquired.hpp.acquired_sdk.HPPManager;
import com.acquired.hpp.acquired_sdk.HPPSetting;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        HPPSetting hppSetting = new HPPSetting(142, 1103, "lixiaoping");
        hppSetting.setIsDebug(true);
        hppSetting.setOrderId("1103123sdf32");
        hppSetting.setTransactionType("AUTH_ONLY");
        hppSetting.setCurrencyCode("GBP");
        hppSetting.setAmount(Float.valueOf("100.1"));
        hppSetting.setErrorUrl("https://www.unfuddle.com");
        HPPManager.init(this, hppSetting);
    }
}
