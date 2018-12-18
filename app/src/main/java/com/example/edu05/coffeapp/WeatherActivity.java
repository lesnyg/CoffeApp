package com.example.edu05.coffeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.WeatherAdapter;
import models.Weather;

public class WeatherActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private WeatherAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mListView = findViewById(R.id.list_view);

        //날씨 데이터
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"충청","27도"));
        weatherList.add(new Weather(R.drawable.ic_rain,"강원","27도"));
        weatherList.add(new Weather(R.drawable.ic_rain,"부산","20도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"서울","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_snow,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_snow,"부산","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_windy,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_windy,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_rain,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_stormy,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_rain,"수원","27도"));
        weatherList.add(new Weather(R.drawable.ic_sun,"수원","27도"));

        madapter = new WeatherAdapter(this,weatherList);
        mListView.setAdapter(madapter);

        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        madapter.setSelect(position);
        //데이터가 변경됨을 알려줌 = 다시그려라
        madapter.notifyDataSetChanged();
    }
}
