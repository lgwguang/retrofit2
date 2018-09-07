package com.retrofit2.converter;

import okhttp3.Response;

public interface Converter<T> {

    T converterResponse(Response response)throws Throwable;

}
