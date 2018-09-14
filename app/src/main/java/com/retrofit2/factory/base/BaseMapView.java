package com.retrofit2.factory.base;

import android.content.Context;
import android.os.Bundle;

import com.retrofit2.factory.IMapView;

public abstract class BaseMapView implements IMapView{

    private Context context;

    public BaseMapView(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

}
