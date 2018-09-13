package com.retrofit2.factory.baidu;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.retrofit2.factory.IMapView;

public class BaiduMapView implements IMapView{

    Context context;

    public BaiduMapView(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public View getView() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }
}
