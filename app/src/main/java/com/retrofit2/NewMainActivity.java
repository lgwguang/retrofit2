package com.retrofit2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.jaeger.library.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;

public class NewMainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    AppBarLayout appbarLayout;
    RelativeLayout toolbar1, toolbar2;
    CollapsingToolbarLayout collapsingToolbar;
    Toolbar toolbar_layout_main_page_home;
    List<Book> mlsit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        initStatuBar1();
        recyclerView = findViewById(R.id.recyclerView);
        appbarLayout = findViewById(R.id.appbarLayout_home);
        collapsingToolbar = findViewById(R.id.collapsingToolbar);
        toolbar_layout_main_page_home = findViewById(R.id.toolbar_layout_main_page_home);
        toolbar1 = findViewById(R.id.toolbar1);
        toolbar2 = findViewById(R.id.toolbar2);
        appbarLayout.addOnOffsetChangedListener(onOffsetChangedListener);

        initBook();
        initData();
    }

    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = new AppBarLayout.OnOffsetChangedListener() {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            Log.d("TAG","滑动距离："+verticalOffset+"，总距离："+appBarLayout.getTotalScrollRange());
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            if(verticalOffset<=0){
                //向上滑动
                if(Math.abs(verticalOffset)==totalScrollRange){
                    toolbar2.setVisibility(View.VISIBLE);
                    toolbar1.setVisibility(View.GONE);

//                    AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//初始化操作，参数传入1和0，即由透明度1变化到透明度为0
//                    toolbar2.startAnimation(alphaAnimation);//开始动画
//                    alphaAnimation.setFillAfter(true);//动画结束后保持状态
//                    alphaAnimation.setDuration(2000);//动画持续时间
//                    setColor(Math.abs(verticalOffset));
                    initStatuBar();
                }else{
                    initStatuBar1();
                    toolbar2.setVisibility(View.GONE);
                    toolbar1.setVisibility(View.VISIBLE);

                }
            }else{


            }

        }
    };

    public void setColor(float fraction){
        int i = changeAlpha(android.R.color.darker_gray, fraction);
        collapsingToolbar.setBackgroundColor(i);
    }



    /** 根据百分比改变颜色透明度 */
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * Math.abs(fraction));
        return Color.argb(alpha, red, green, blue);
    }
    private void initData() {
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        BookBaseAdapter adapter = new BookBaseAdapter(mlsit);
        recyclerView.setAdapter(adapter);
    }

    class BookBaseAdapter extends RecyclerView.Adapter<BookViewHolder>{
        private List<Book> mBookList;
        public BookBaseAdapter(List<Book> mBookList) {
            this.mBookList = mBookList;
        }


        @NonNull
        @Override
        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book,parent,false);
            BookViewHolder holder = new BookViewHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
            Book book = mBookList.get(position);
            holder.bookname.setText(book.name);
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }


    }
    static class BookViewHolder extends RecyclerView.ViewHolder{
        TextView bookname;

        public BookViewHolder(View view) {
            super(view);
            bookname = (TextView) view.findViewById(R.id.book_name);
        }
    }
    class Book{
        private String name;
        public Book(String name){
            this.name = name;
        }
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
    private void initStatuBar1() {
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this, Color.parseColor("#0000FF"),0);
    }
}
