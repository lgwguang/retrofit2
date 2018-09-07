package com.retrofit2.converter;

import android.util.JsonReader;

import java.lang.reflect.Type;

import okhttp3.Response;

public class JsonConvert<T> implements Converter<T>{

    private Type type;
    private Class<T> clazz;

    public JsonConvert() {
    }

    public JsonConvert(Type type) {
        this.type = type;
    }

    public JsonConvert(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T converterResponse(Response response) throws Throwable {
        JsonReader jsonReader = new JsonReader(response.body().charStream());

        return null;
    }
}
