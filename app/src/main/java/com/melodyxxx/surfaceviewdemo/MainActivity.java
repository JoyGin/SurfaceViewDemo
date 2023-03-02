package com.melodyxxx.surfaceviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DynamicWeatherView mDynamicWeatherView = (DynamicWeatherView) findViewById(R.id.dynamic_weather_view);
        mDynamicWeatherView.setType(new RainTypeImpl(this, mDynamicWeatherView));

        // 裁剪方法一
//        mDynamicWeatherView.setClipToOutline(true);
//        mDynamicWeatherView.setOutlineProvider(new ViewOutlineProvider() {
//            @Override
//            public void getOutline(View view, Outline outline) {
//                outline.setRect(new Rect(100, 100, 200, 200));
//            }
//        });
//        mDynamicWeatherView.getHolder().setFixedSize(150, 150);

        // 裁剪方法二
        mDynamicWeatherView.setClipBounds(new Rect(0, 0, 200, 200));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getWindow().setStatusBarColor(Color.WHITE);
    }
}
