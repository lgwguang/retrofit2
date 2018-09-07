package com.retrofit2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaeger.library.StatusBarUtil;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStatuBar();
        initData();
        initDevices();
    }

    private void initStatuBar() {
        StatusBarUtil.setLightMode(this);
        StatusBarUtil.setColor(this, Color.parseColor("#FFFFFF"),0);
    }

    private void initDevices(){
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm =new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        Toast.makeText(this,"屏幕密度："+densityDpi+"，屏幕密度："+density,Toast.LENGTH_LONG).show();
        System.out.println("屏幕密度："+densityDpi+"，屏幕密度："+density+"，屏幕宽度："+widthPixels+"，屏幕高度："+heightPixels);
    }

    private void initData() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                //.addNetworkInterceptor(authorizationInterceptor)
                .build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<ResposeData<Repo>> call = service.listRepos("");
        call.enqueue(new Callback<ResposeData<Repo>>() {
            @Override
            public void onResponse(Call<ResposeData<Repo>> call, Response<ResposeData<Repo>> response) {
                System.out.println("请求数据："+response.toString());
                System.out.println("请求数据："+response.body().list);
            }

            @Override
            public void onFailure(Call<ResposeData<Repo>> call, Throwable t) {
                    t.printStackTrace();
            }
        });


//        Call<ResponseBody> call = service.listRepos("");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                System.out.println("请求数据："+response.toString());
//                try {
//                    System.out.println(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("==========================");
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//                System.out.println("请求数据："+t.getMessage());
//            }
//        });

    }
}
