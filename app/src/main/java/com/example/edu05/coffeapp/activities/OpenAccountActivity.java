package com.example.edu05.coffeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edu05.coffeapp.R;
import com.example.edu05.coffeapp.managers.Bank;

import com.example.edu05.coffeapp.models.Account;

public class OpenAccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_account);

        findViewById(R.id.open_button).setOnClickListener(this);
    }


    public void onClick(View view) {
        Bank bank = Bank.newInstance();

        String id = ((EditText)findViewById(R.id.id_editText)).getText().toString();
        String password = ((EditText)findViewById(R.id.pass_editText)).getText().toString();
        int balance = Integer.parseInt(((EditText)findViewById(R.id.balance_editText)).getText().toString());

        Account account = new Account(id,password,balance);

        bank.open(account);

        Toast.makeText(this, "개설되었습니다.", Toast.LENGTH_SHORT).show();

         finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
