package com.retrofit2.factory.baidu;

import android.content.Context;

import com.retrofit2.factory.IMapLocation;
import com.retrofit2.factory.IMapView;
import com.retrofit2.factory.base.BaseMapFactory;

public class BaiduMapFactory extends BaseMapFactory {

    private IMapView mapView;

    public BaiduMapFactory(Context context) {
        super(context);
    }

    @Override
    public IMapView getMapView() {
        if(mapView == null){
            this.mapView = new BaiduMapView(getContext());
        }
        return mapView;
    }

    @Override
    public IMapLocation getMapLocation() {
        return new BaiduMapLocation(getContext());
    }
}
