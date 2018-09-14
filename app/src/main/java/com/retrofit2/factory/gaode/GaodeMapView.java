package com.retrofit2.factory.gaode;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.MapView;
import com.retrofit2.factory.base.BaseMapView;

public class GaodeMapView extends BaseMapView{

    private MapView mapView;
    public GaodeMapView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        if(mapView == null){
            mapView = new MapView(getContext());
        }
        return mapView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.mapView.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        this.mapView.onPause();
    }

    @Override
    public void onDestroy() {
        this.mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        this.mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        this.mapView.onResume();
    }
}
