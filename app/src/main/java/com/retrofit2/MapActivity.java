package com.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.retrofit2.factory.IMapFactory;
import com.retrofit2.factory.IMapView;
import com.retrofit2.factory.gaode.GaodeMapFactory;

public class MapActivity extends AppCompatActivity {

    private IMapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//        IMapFactory factory = new BaiduMapFactory(this);
//        mMapView = factory.getMapView();
//        FrameLayout frameLayout = findViewById(R.id.framelayout);
//        frameLayout.addView(mMapView.getView());
//        mMapView.onCreate(savedInstanceState);

        IMapFactory factory = new GaodeMapFactory(this);
        mMapView = factory.getMapView();
        FrameLayout frameLayout = findViewById(R.id.framelayout);
        frameLayout.addView(mMapView.getView());
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}
