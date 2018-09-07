package com.retrofit2;

import java.io.Serializable;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public class ResposeData<T> implements Serializable {

    public int errorCode;
    public String errorMsg;
    public T list;

    @Override
    public String toString() {
        return "ResposeData{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", list=" + list +
                '}';
    }
}
