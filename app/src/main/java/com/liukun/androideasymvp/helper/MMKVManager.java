package com.liukun.androideasymvp.helper;

import android.content.Context;

import com.tencent.mmkv.MMKV;

/**
 * Author: liukun on 2020/6/8.
 * Mail  : 3266817262@qq.com
 * Description: mmk 解决方案的管理类
 */
public class MMKVManager {
    private static volatile MMKVManager INSTANCE;
    private static MMKV kv;

    private MMKVManager() {
    }

    public static void init(Context context) {
        MMKV.initialize(context.getApplicationContext());
    }

    // 获取对象
    public static MMKVManager getInstance() {
        if (kv == null) {
            kv =  MMKV.mmkvWithID("business_mmkvmanager", MMKV.MULTI_PROCESS_MODE);
        }
        if (INSTANCE == null) {
            synchronized (MMKVManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MMKVManager();
                }
            }
        }
        return INSTANCE;
    }


    public Boolean putToken(String token){
        return putString("token",token);
    }
    public String  getToken(){
        return getString("token","");
    }
    public boolean  isLogin(){
        return getBoolean("isLogin",false);
    }
    public boolean putInt(String key, int value) {
        return kv.encode(key, value);
    }

    public int getInt(String key, int defValue) {
        return kv.decodeInt(key, defValue);
    }

    public boolean putLong(String key, long value) {
        return kv.encode(key, value);
    }

    public long getLong(String key, long defValue) {
        return kv.decodeLong(key, defValue);
    }

    public boolean putString(String key, String value) {
        return kv.encode(key, value);
    }

    public String getString(String key, String defValue) {
        return kv.decodeString(key, defValue);
    }

    public boolean putBoolean(String key, boolean value) {
        return kv.encode(key, value);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return kv.decodeBool(key, defValue);
    }

    public boolean putByte(String key, byte[] value) {
        return kv.encode(key, value);
    }

    public byte[] getByte(String key) {
        return kv.decodeBytes(key);
    }

    public boolean putDouble(String key, double value) {
        return kv.encode(key, value);
    }

    public double getDouble(String key, double defValue) {
        return kv.decodeDouble(key, defValue);
    }

    public boolean putFloat(String key, float value) {
        return kv.encode(key, value);
    }

    public float getFloat(String key, float defValue) {
        return kv.decodeFloat(key, defValue);
    }

    public void remove(String key) {
        kv.remove(key);
    }

    public void clearAll() {
        kv.clearAll();
    }
}
