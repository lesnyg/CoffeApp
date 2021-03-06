package com.example.edu05.coffeapp.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edu05.coffeapp.R;

public class coffeeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int QUANTITY_MIN = 0;
    public static final int QUANTITY_MAX = 10;
    public static final int COFFEE_PRICE = 3000;
    public static final int CREAM_PRICE=500;

    private Button mMinusButton;
    private Button mPlusButton;
    private TextView mQuantityTextView;
    private Button mOrderButton;
    private TextView mResultTextView;
    private CheckBox mCreamCheckBox;
    private EditText mCommentEditText;
    private int mQuantity;
    private boolean mIsCream;
    private Chronometer mChronometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_coffee);
        mChronometer = new Chronometer(this);


        mMinusButton = findViewById(R.id.minus_button);
        mMinusButton.setOnClickListener(this);
        mPlusButton = findViewById(R.id.plus_button);
        mPlusButton.setOnClickListener(this);
        mOrderButton = findViewById(R.id.order_button);
        mOrderButton.setOnClickListener(this);
        mQuantityTextView = findViewById(R.id.quantity_text);
        mResultTextView = findViewById(R.id.result_text);
        mCreamCheckBox = findViewById(R.id.cream_check);
        mCommentEditText = findViewById(R.id.comment_edit);
        mChronometer = findViewById(R.id.chronometer);
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee,menu);
        return true;
    }

    private void displayResult() {
        mQuantityTextView.setText(""+mQuantity);
        int total = COFFEE_PRICE*mQuantity;
        if(mIsCream){
            total += CREAM_PRICE;
        }else{
            total -= CREAM_PRICE;

        }
        String result = String.format("가격 : %d원\n수량 : %d개\n휘핑크림 : %s\n",
                total,mQuantity,mIsCream);
        mResultTextView.setText(result);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                Toast.makeText(this, "첫번째 메뉴", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu2:
                sound();
                return true;
            case R.id.action_menu3:
                startChronometer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startChronometer() {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }


    private void init() {  mQuantity = 0;   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.minus_button:
                mQuantity--;
                if(mQuantity< QUANTITY_MIN){ mQuantity=QUANTITY_MIN;}
                displayResult();
                break;
            case R.id.plus_button:
                mQuantity++;
                if(mQuantity> QUANTITY_MAX){ mQuantity=QUANTITY_MAX;}
                displayResult();
                break;
            case R.id.order_button:
                String message = mResultTextView.getText().toString();
                Intent intent = new Intent(this,OrderCheckActivity.class);
                intent.putExtra("result",message);
                intent.putExtra("comment",mCommentEditText.getText().toString());
                startActivity(intent);
                break;
        }
    }
    private void sound(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.baby_music);
        mediaPlayer.start();
    }
}
