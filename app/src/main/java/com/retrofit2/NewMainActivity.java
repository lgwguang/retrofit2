package com.retrofit2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewMainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    AppBarLayout appbarLayout_home;
    RelativeLayout toolbar1, toolbar2;

    List<Book> mlsit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        initStatuBar();
        recyclerView = findViewById(R.id.recyclerView);
        appbarLayout_home = findViewById(R.id.appbarLayout_home);
        toolbar1 = findViewById(R.id.toolbar1);
        toolbar2 = findViewById(R.id.toolbar2);
        initBook();
        initData();
    }

    private void initData() {

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        BookBaseAdapter adapter = new BookBaseAdapter(mlsit);
        recyclerView.setAdapter(adapter);
    }

    class BookBaseAdapter extends RecyclerView.Adapter<ViewHolder>{
        private List<Book> mBookList;
        public BookBaseAdapter(List<Book> mBookList) {
            this.mBookList = mBookList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Book book = mBookList.get(position);
            holder.bookname.setText(book.name);
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }


    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookname;

        public ViewHolder(View view) {
            super(view);
            bookname = (TextView) view.findViewById(R.id.book_name);
        }
    }
    class Book{
        public String name;
        public Book(String name){}
    }

    private void initBook() {
        for (int i = 0; i < 10; i++) {
            Book book01 = new Book("Book" + i);
            mlsit.add(book01);
            Book book02 = new Book("Book" + i);
            mlsit.add(book02);
            Book book03 = new Book("Book" + i);
            mlsit.add(book03);
        }
    }

        private void initStatuBar() {
        StatusBarUtil.setLightMode(this);
        StatusBarUtil.setColor(this, Color.parseColor("#FFFFFF"),0);
    }
}
