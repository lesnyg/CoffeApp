package com.example.edu05.coffeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import adapters.WeatherAdapter;
import models.Weather;

public class WeatherActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView mListView;
    private WeatherAdapter madapter;
    private List<Weather> mWeatherList;
    private GridView mGridView;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mListView = findViewById(R.id.list_view);
        mGridView = findViewById(R.id.grid_view);
        mSpinner = findViewById(R.id.spinner);

        //날씨 데이터
        mWeatherList = new ArrayList<>();
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"충청","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_rain,"강원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_rain,"부산","20도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"서울","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_snow,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_snow,"부산","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_windy,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_windy,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_rain,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_stormy,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_rain,"수원","27도"));
        mWeatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));

        //어댑터
        madapter = new WeatherAdapter(this, mWeatherList);
        //어댑터를 뷰에 설정
        mListView.setAdapter(madapter);
        mGridView.setAdapter(madapter);
        mSpinner.setAdapter(madapter);

        //이벤트
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        madapter.setSelect(position);
        //데이터가 변경됨을 알려줌 = 다시그려라
        madapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //롱 클릭시 해당 아이템 삭제
        mWeatherList.remove(position);

        //어댑터에 변경을 통지 = 다시 그려라
        madapter.notifyDataSetChanged();
        return false;
    }
}
