package com.retrofit2.factory.base;

import android.content.Context;

import com.retrofit2.factory.IMapFactory;

public abstract class BaseMapFactory implements IMapFactory {

    private Context context;
    public BaseMapFactory(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
