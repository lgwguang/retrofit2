package com.retrofit2.factory;

import android.os.Bundle;
import android.view.View;

public interface IMapView {

    View getView();

    void onCreate(Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onDestroy();

    void onSaveInstanceState(Bundle outState);
}
