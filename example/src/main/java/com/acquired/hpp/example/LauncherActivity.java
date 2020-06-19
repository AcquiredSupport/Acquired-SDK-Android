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
                hppSetting.setCustomerFname("Joe");
                hppSetting.setCustomerLname("Bloggs");
                hppSetting.setCustomerDob("1990-01-01");
                hppSetting.setBillingStreet("152 Aldgate Drive");
                hppSetting.setBillingCity("London");
                hppSetting.setBillingZipcode("E1 7RT");
                hppSetting.setBillingCountryCodeISO2("GB");
                hppSetting.setBillingPhoneCode("44");
                hppSetting.setBillingPhone("2039826580");
                hppSetting.setBillingEmail("support@acquired.com");
                hppSetting.setMerchantContactURL("https://acquired.com/support");
                hppSetting.setCallBackUrl("https://yoururl.com/callback");
                hppSetting.setReturnMethod("post_message");
                hppSetting.setIsTDS(2);
                hppSetting.setTDSType(2);
                hppSetting.setTDSPreference(0);
                HPPManager.init(view.getContext(), hppSetting);
            }
        });

    }

    private String generateOrderId() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        return f.format(new Date());
    }
}
