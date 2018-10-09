package com.acquired.hpp.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.acquired.hpp.acquired_sdk.HPPManager;
import com.acquired.hpp.acquired_sdk.HPPSetting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        Button btnPayNow = (Button) this.findViewById(R.id.btnPayNow);
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HPPSetting hppSetting = new HPPSetting(211, 1229, "hashcode");
                hppSetting.setIsDebug(true);
                hppSetting.setOrderId(generateOrderId());
                hppSetting.setTransactionType("AUTH_ONLY");
                hppSetting.setCurrencyCode("GBP");
                hppSetting.setAmount(Float.valueOf("100.1"));
                hppSetting.setErrorUrl("https://docs.acquired.com/error");
                hppSetting.setReturnUrl("https://docs.acquired.com/return");
                hppSetting.setCallBackUrl("https://docs.acquired.com/callback");
                HPPManager.init(view.getContext(), hppSetting);
            }
        });

    }

    private String generateOrderId() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        return f.format(new Date());
    }
}
