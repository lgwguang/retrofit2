package com.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.retrofit2.factory.IMapView;
import com.retrofit2.factory.baidu.BaiduMapView;

public class MapActivity extends AppCompatActivity {

    private IMapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapView = new BaiduMapView(this);
        FrameLayout frameLayout = findViewById(R.id.framelayout);
        frameLayout.addView(mMapView.getView());
        mMapView.onCreat(savedInstanceState);
    }
}
