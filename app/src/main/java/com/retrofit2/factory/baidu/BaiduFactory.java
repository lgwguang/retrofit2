package com.retrofit2.factory.baidu;

import android.content.Context;
import com.retrofit2.factory.IMapView;
import com.retrofit2.factory.base.BaseFactory;

public class BaiduFactory implements BaseFactory {

    Context context;
    public BaiduFactory(Context context) {
        this.context = context;
    }

    @Override
    public IMapView getMapView() {
        return new BaiduMapView(context);
    }
}
