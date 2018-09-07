package com.retrofit2;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

public interface GitHubService {

    //@HTTP(method = "GET",path = "banner/json/{id}",hasBody = false)

//    @GET("banner/json/{id}")
//    Call<ResponseBody> listRepos(@Path("id") String id);
    @GET("banner/json/{id}")
    Call<ResposeData<Repo>> listRepos(@Path("id") String id);
}
