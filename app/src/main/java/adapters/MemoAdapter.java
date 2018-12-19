package adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edu05.coffeapp.R;

import java.util.List;

import models.Memo;
import models.Weather;

public class MemoAdapter extends BaseAdapter {
    private final List<Memo> mData;
    public MemoAdapter(List<Memo> mMemoList) {
        mData = mMemoList;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //convertView : 재사용 되는뷰
        if(convertView==null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_memo,
                    parent, false);


            //레이아웃 들고오기
            TextView titleTextView = convertView.findViewById(R.id.title_text);
            TextView contentTextView = convertView.findViewById(R.id.content_text);

            viewHolder.titleTextView = titleTextView;
            viewHolder.contentTextView = contentTextView;

            convertView.setTag(viewHolder);
        }else {
            //재사용 할 때
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //데이터사져오기
        Memo memo = mData.get(position);

        //화면에 뿌리기기
        viewHolder.titleTextView.setText(memo.getTitle());
        viewHolder.contentTextView.setText(memo.getContent());

        return convertView;
    }

    //findViewById로 가져온 View들을 보관
    private static class ViewHolder{
        TextView titleTextView;
        TextView contentTextView;
    }

}
