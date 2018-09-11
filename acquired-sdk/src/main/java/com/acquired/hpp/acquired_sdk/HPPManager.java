package com.acquired.hpp.acquired_sdk;

import android.content.Context;
import android.content.Intent;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Copyright (c) 2018 @Acquired
 * <p>
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 * <p>
 * Created by Leo on 07/08/2018.
 */
public class HPPManager {
    private HPPManager() {
    }

    private static HPPManager hppManager;

    public static HPPManager getInstance() {
        if (hppManager == null) {
            hppManager = new HPPManager();
        }
        return hppManager;
    }

    /**
     * Using this function to call and initialize acquired hpp
     *
     * @param packageContext based on which context to show acquired hpp
     * @param hppSetting     Parameters and settings that hpp will use.
     */
    public static void init(Context packageContext, HPPSetting hppSetting) {
        try {
            Intent intent = new Intent(packageContext, HppActivity.class);
            String hppURL = HPPManager.getInstance().getHppUrl(hppSetting);
            intent.putExtra("HPPURL", hppURL);
            packageContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate valid hpp url
     *
     * @param hppSetting Parameters and settings that hpp will use.
     * @return validated acquired hpp url
     */
    private String getHppUrl(HPPSetting hppSetting) {
        Map<String, Object> parameter = HPPManager.getInstance().ConvertObjectToMap(hppSetting);
        String url = hppSetting.getIsDebug() ? "https://qahpp2.acquired.com" : "https://hpp.acquired.com";
        url += "/?" + HPPManager.getInstance().HttpBuildQuery(parameter);
        url += "&hash=" + HPPManager.getInstance().getHppHash(parameter, hppSetting.getCompanyHash());
        return url;
    }

    /**
     * Encrypt all parameter included in hpp url which will be valid on acquired server side.
     *
     * @param parameter Parameters and settings that hpp will use.
     * @param hash      mid hash code
     * @return
     */
    private String getHppHash(Map<String, Object> parameter, String hash) {
        StringBuffer sb = new StringBuffer();
        for (Iterator iterator = parameter.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (java.util.Map.Entry) iterator.next();
            sb.append(null == entry.getValue() ? "" :
                    entry.getValue().toString());
        }
        return String2SHA256(String2SHA256(sb.toString()) + hash);

    }

    /**
     * Convert HppSetting to hash map
     *
     * @param obj HppSetting
     * @return Hash map
     */
    private Map<String, Object> ConvertObjectToMap(Object obj) {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                String name = field.getName();
                Object value = field.get(obj);
                if (name == "serialVersionUID" || name == "is_debug" || value == null || value == "") continue;
                if (name == "template_id" && field.getInt(obj) < 1) continue;
                if (name == "company_hash" || name == "mid_hash") continue;
                map.put(name, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Map<String, Object> sortMap = new TreeMap<String, Object>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * Combine all parameters to a query string
     *
     * @param array
     * @return query string like "key=value&key2=value2"
     */
    private static String HttpBuildQuery(Map<String, Object> array) {
        String reString = "";
        Iterator it = array.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) it.next();
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            reString += key + "=" + value + "&";
        }
        reString = reString.substring(0, reString.length() - 1);
//        try {
//            reString = java.net.URLEncoder.encode(reString, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        reString = reString.replace("%3D", "=").replace("%26", "&");
        return reString;
    }

    /**
     * Encrypt a string using SHA256
     *
     * @param str
     * @return
     */
    private static String String2SHA256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * Sort an array
     */
    class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }

}
