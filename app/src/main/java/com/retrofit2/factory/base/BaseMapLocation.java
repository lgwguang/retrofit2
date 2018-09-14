package com.retrofit2.factory.base;

import android.content.Context;

import com.retrofit2.factory.IMapLocation;

public abstract class BaseMapLocation implements IMapLocation{

    private Context context;

    public BaseMapLocation(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
