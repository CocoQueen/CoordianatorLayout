package com.example.coco.test0327;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView mTv;
    private SliderLayout slider;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDate();


    }

    private void initDate() {
        //滑动轮播的数据源初始化

        //将图片网址存入map结合里面
        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("1", "http://p0.so.qhimgs1.com/t016e00c9485326b764.jpg");
        url_maps.put("2", "http://p0.so.qhimgs1.com/t01dc3718ec509e0050.jpg");
        url_maps.put("3", "http://p0.so.qhimgs1.com/t0124a6870f243a4be4.jpg");
        url_maps.put("4", "http://p2.so.qhimgs1.com/t014bb11b1742a1998e.jpg");

        for (String name : url_maps.keySet()) {//将数据进行遍历，使得图片进行轮播
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(url_maps.get(name))//添加网络图片的网址的集合
                    .setScaleType(BaseSliderView.ScaleType.Fit);//图片填充类型
            slider.addSlider(textSliderView);//为slider添加数据

            //修改轮播动画
            slider.setPresetTransformer(SliderLayout.Transformer.Default);
            slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);//指示器位置
            slider.setDuration(4000);//间隔时间
        }
        //初始化菜单栏
        mTab.addTab(mTab.newTab().setText("新闻"), 0);
        mTab.addTab(mTab.newTab().setText("娱乐"), 1);
        mTab.addTab(mTab.newTab().setText("社会"), 2);

        int position = mTab.getSelectedTabPosition();//根据所选的tab设置数据
        if (position==0){
            //初始化列表
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 100; i++) {//通过for循环进行数据的添加
                builder.append("data" + i + "\n");
            }
            String str = builder.toString();
            mTv.setText(str);//将上述数据添加到tv上
        }else if (position==1){
            //初始化列表
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 50; i++) {//通过for循环进行数据的添加
                builder.append("data" + i + "\n");
            }
            String str = builder.toString();
            mTv.setText(str);//将上述数据添加到tv上
        }else if (position==3){
            //初始化列表
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 10; i++) {//通过for循环进行数据的添加
                builder.append("data" + i + "\n");
            }
            String str = builder.toString();
            mTv.setText(str);//将上述数据添加到tv上
        }


    }

    private void initView() {
        //查找控件
        slider = findViewById(R.id.slider);
        mTab = findViewById(R.id.mTab);
        mTv = findViewById(R.id.mTv);
    }
}
