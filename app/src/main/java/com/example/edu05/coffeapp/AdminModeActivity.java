package com.example.edu05.coffeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.edu05.coffeapp.managers.Bank;

import java.util.List;

import models.Account;
import models.Memo;

public class AdminModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mode);

        ListView listView = findViewById(R.id.account_info_list);

        Bank bank = Bank.newInstance();

        BankAdapter adapter = new BankAdapter(bank.getAccountList());

        listView.setAdapter(adapter);
    }

    public void onClick(View view) { finish();  }

    private static class BankAdapter extends BaseAdapter{

        private final List<Account> mData;

        public BankAdapter(List<Account> accountList){
            mData = accountList;
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

                //뷰를 새로 만들때
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_account_info,
                                parent, false);


                //레이아웃 들고오기
                TextView idTextView = convertView.findViewById(R.id.account_title_text);
                TextView balanceTextView = convertView.findViewById(R.id.balance_text);

                viewHolder.idTextView = idTextView;
                viewHolder.balanceTextView = balanceTextView;

                convertView.setTag(viewHolder);
            }else {
                //재사용 할 때
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //데이터사져오기
            Account account = mData.get(position);

            //화면에 뿌리기기
            viewHolder.idTextView.setText(account.getId());
            viewHolder.balanceTextView.setText(""+account.getBalace());

            return convertView;
        }

        //findViewById로 가져온 View들을 보관
        private static class ViewHolder{
            TextView idTextView;
            TextView balanceTextView;
        }

        }
    }

