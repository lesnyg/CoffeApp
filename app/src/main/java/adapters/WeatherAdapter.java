package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edu05.coffeapp.R;

import org.w3c.dom.Text;

import java.util.List;

import models.Weather;

public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private List<Weather> mData;
    public WeatherAdapter(Context context, List<Weather> data){
        mContext = context;
        mData = data;

    }

    //아이템 갯수를 나타냄 우리가 정해주는것
    @Override
    public int getCount() {
        return mData.size();
    }

    //position번째 아이템
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    //position번째 id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //position번째의 레이아웃을 정의
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView :재사용되는 뷰
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_weather,
                    parent,false);
        }

        //레이아웃 들고오기
        ImageView imageView = convertView.findViewById(R.id.weather_image);
        TextView locationTextView = convertView.findViewById(R.id.location_text);
        TextView temperatureTextView = convertView.findViewById(R.id.temperrature_text);

        //데이터사져오기
        Weather weather = mData.get(position);

        //화면에 뿌리기기
       imageView.setImageResource(weather.getImageres());
        locationTextView.setText(weather.getLocation());
        temperatureTextView.setText(weather.getTemperature());

        return convertView;
    }
}