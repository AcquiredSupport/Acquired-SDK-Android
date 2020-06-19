package com.acquired.hpp.acquired_sdk;

import java.io.Serializable;

/**
 * Copyright (c) 2018 @Acquired
 * <p>
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 * <p>
 * Created by Leo on 07/08/2018.
 */
public class HPPSetting implements Serializable {
    private int company_id;
    private int company_mid_id;
    private String mid_hash;
    private String transaction_type;
    private String currency_code_iso3;
    private String merchant_order_id;
    private int template_id;
    private float amount;
    private String callback_url;
    private String return_url;
    private String error_url;

    private String merchant_customer_id;
    private String merchant_custom_1;
    private String merchant_custom_2;
    private String merchant_custom_3;
    private String merchant_contact_url;
    private String customer_title;
    private String customer_fname;
    private String customer_mname;
    private String customer_lname;
    private String customer_gender;
    private String customer_dob;
    private String customer_company;

    private String billing_street;
    private String billing_street2;
    private String billing_city;
    private String billing_state;
    private String billing_zipcode;
    private String billing_country_code_iso2;
    private String billing_email;
    private String billing_phone;
    private String billing_phone_code;


    private String shipping_street;
    private String shipping_street2;
    private String shipping_city;
    private String shipping_state;
    private String shipping_zipcode;
    private String shipping_country_code_iso2;
    private String shipping_email;
    private String shipping_phone;

    private int is_tds;
    private int tds_source;
    private int tds_type;
    private int tds_preference;

    private String return_method;

    public Boolean getIsDebug() {
        return is_debug;
    }

    public void setIsDebug(Boolean is_live) {
        this.is_debug = is_live;
    }

    private Boolean is_debug = false;

    public int getCompanyId() {
        return company_id;
    }

    public int getCompanyMidId() {
        return company_mid_id;
    }

    public String getCompanyHash() {
        return mid_hash;
    }

    public String getTransactionType() {
        return transaction_type;
    }

    public void setTransactionType(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getCurrencyCode() {
        return currency_code_iso3;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currency_code_iso3 = currencyCode;
    }

    public String getOrderId() {
        return merchant_order_id;
    }

    public void setOrderId(String orderId) {
        this.merchant_order_id = orderId;
    }

    public int getTemplateId() {
        return template_id;
    }

    public void setTemplateId(int templateId) {
        this.template_id = templateId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCallBackUrl() {
        return callback_url;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callback_url = callBackUrl;
    }

    public String getReturnUrl() {
        return return_url;
    }

    public void setReturnUrl(String returnUrl) {
        this.return_url = returnUrl;
    }

    public String getErrorUrl() {
        return error_url;
    }

    public void setErrorUrl(String errorUrl) {
        this.error_url = errorUrl;
    }


    public void setCompanyId(int companyId) {
        this.company_id = companyId;
    }

    public void setCompanyMidId(int company_mid_id) {
        this.company_mid_id = company_mid_id;
    }

    public void setCompanyHash(String mid_hash) {
        this.mid_hash = mid_hash;
    }

    public String getMerchantCustomerId() {
        return merchant_customer_id;
    }

    public void setMerchantCustomerId(String merchantCustomerId) {
        this.merchant_customer_id = merchantCustomerId;
    }

    public String getMerchantCustomer1() {
        return merchant_custom_1;
    }

    public void setMerchantCustomer1(String merchantCustomer1) {
        this.merchant_custom_1 = merchantCustomer1;
    }

    public String getMerchantCustomer2() {
        return merchant_custom_2;
    }

    public void setMerchantCustomer2(String merchantCustomer2) {
        this.merchant_custom_2 = merchantCustomer2;
    }

    public String getMerchantCustomer3() {
        return merchant_custom_3;
    }

    public void setMerchantCustomer3(String merchantCustomer3) {
        this.merchant_custom_3 = merchantCustomer3;
    }

    public String getMerchantContactURL() {
        return merchant_contact_url;
    }

    public void setMerchantContactURL(String merchant_contact_url) {
        this.merchant_contact_url = merchant_contact_url;
    }


    public String getCustomerTitle() {
        return customer_title;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customer_title = customerTitle;
    }

    public String getCustomerFname() {
        return customer_fname;
    }

    public void setCustomerFname(String customerFname) {
        this.customer_fname = customerFname;
    }

    public String getCustomerMname() {
        return customer_mname;
    }

    public void setCustomerMname(String customerMname) {
        this.customer_mname = customerMname;
    }

    public String getCustomerLname() {
        return customer_lname;
    }

    public void setCustomerLname(String customerLname) {
        this.customer_lname = customerLname;
    }

    public String getCustomerGender() {
        return customer_gender;
    }

    public void setCustomerGender(String customerGender) {
        this.customer_gender = customerGender;
    }

    public String getCustomerDob() {
        return customer_dob;
    }

    public void setCustomerDob(String customerDob) {
        this.customer_dob = customerDob;
    }

    public String getCustomerCompany() {
        return customer_company;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customer_company = customerCompany;
    }

    public String getBillingStreet() {
        return billing_street;
    }

    public void setBillingStreet(String billingStreet) {
        this.billing_street = billingStreet;
    }

    public String getBillingStreet2() {
        return billing_street2;
    }

    public void setBillingStreet2(String billingStreet2) {
        this.billing_street2 = billingStreet2;
    }

    public String getBillingCity() {
        return billing_city;
    }

    public void setBillingCity(String billingCity) {
        this.billing_city = billingCity;
    }

    public String getBillingState() {
        return billing_state;
    }

    public void setBillingState(String billingState) {
        this.billing_state = billingState;
    }

    public String getBillingZipcode() {
        return billing_zipcode;
    }

    public void setBillingZipcode(String billingZipcode) {
        this.billing_zipcode = billingZipcode;
    }

    public String getBillingCountryCodeISO2() {
        return billing_country_code_iso2;
    }

    public void setBillingCountryCodeISO2(String billingCountryCodeISO2) {
        this.billing_country_code_iso2 = billingCountryCodeISO2;
    }

    public String getBillingEmail() {
        return billing_email;
    }

    public void setBillingEmail(String billingEmail) {
        this.billing_email = billingEmail;
    }

    public String getBillingPhone() {
        return billing_phone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billing_phone = billingPhone;
    }

    public String getBillingPhoneCode() {
        return this.billing_phone_code;
    }

    public void setBillingPhoneCode(String billingPhoneCode) {
        this.billing_phone_code = billingPhoneCode;
    }


    public String getShippingStreet() {
        return shipping_street;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shipping_street = shippingStreet;
    }

    public String getShippingStreet2() {
        return shipping_street2;
    }

    public void setShippingStreet2(String shippingStreet2) {
        this.shipping_street2 = shippingStreet2;
    }

    public String getShippingCity() {
        return shipping_city;
    }

    public void setShippingCity(String shippingCity) {
        this.shipping_city = shippingCity;
    }

    public String getShippingState() {
        return shipping_state;
    }

    public void setShippingState(String shippingState) {
        this.shipping_state = shippingState;
    }

    public String getShippingZipcode() {
        return shipping_zipcode;
    }

    public void setShippingZipcode(String shippingZipcode) {
        this.shipping_zipcode = shippingZipcode;
    }

    public String getShippingCountryCodeISO2() {
        return shipping_country_code_iso2;
    }

    public void setShippingCountryCodeISO2(String shippingCountryCodeISO2) {
        this.shipping_country_code_iso2 = shippingCountryCodeISO2;
    }

    public String getShippingEmail() {
        return shipping_email;
    }

    public void setShippingEmail(String shippingEmail) {
        this.shipping_email = shippingEmail;
    }

    public String getShippingPhone() {
        return shipping_phone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shipping_phone = shippingPhone;
    }



    public int getIsTDS() {
        return this.is_tds;
    }

    public void setIsTDS(int is_tds) {
        this.is_tds = is_tds;
    }


    public int getTDSSource() {
        return this.tds_source;
    }

    public void setTDSSource(int tds_source) {
        this.tds_source = tds_source;
    }

    public int getTDSType() {
        return this.tds_type;
    }

    public void setTDSType(int tds_type) {
        this.tds_type = tds_type;
    }

    public int getTDSPreference() {
        return this.tds_preference;
    }

    public void setTDSPreference(int tds_preference) {
        this.tds_preference = tds_preference;
    }

    public String getReturnMethod() {
        return return_method;
    }

    public void setReturnMethod(String returnMethod) {
        this.return_method = returnMethod;
    }

    public HPPSetting(int companyId, int companyMidId, String companyHash) {
        this.company_id = companyId;
        this.company_mid_id = companyMidId;
        this.mid_hash = companyHash;
    }

}
