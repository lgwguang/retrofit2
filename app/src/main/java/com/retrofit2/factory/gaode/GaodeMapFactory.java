package com.retrofit2.factory.gaode;

import android.content.Context;

import com.retrofit2.factory.IMapLocation;
import com.retrofit2.factory.IMapView;
import com.retrofit2.factory.baidu.BaiduMapLocation;
import com.retrofit2.factory.baidu.BaiduMapView;
import com.retrofit2.factory.base.BaseMapFactory;

public class GaodeMapFactory extends BaseMapFactory {

    private IMapView mapView;

    public GaodeMapFactory(Context context) {
        super(context);
    }

    @Override
    public IMapView getMapView() {
        if(mapView == null){
            this.mapView = new GaodeMapView(getContext());
        }
        return mapView;
    }

    @Override
    public IMapLocation getMapLocation() {
        return new GaodeMapLocation(getContext());
    }
}
