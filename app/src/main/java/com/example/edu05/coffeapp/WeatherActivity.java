package com.example.edu05.coffeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.WeatherAdapter;
import models.Weather;

public class WeatherActivity extends AppCompatActivity {

    private ListView mListView;
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

        WeatherAdapter adapter = new WeatherAdapter(this,weatherList);
        mListView.setAdapter(adapter);
    }


}
