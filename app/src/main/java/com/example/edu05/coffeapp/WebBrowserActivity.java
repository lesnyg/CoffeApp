package com.example.edu05.coffeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WebBrowserActivity extends AppCompatActivity {
    private EditText mUrlEditText;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        mUrlEditText = findViewById(R.id.url_edit);
        mWebView = findViewById(R.id.web_view);

//        WebSettings mwebSettings = mWebView.getSettings();
//        mwebSettings.setJavaScriptEnabled(true);

        //mWebView.setWebViewClient(new WebViewClient());   <--이것만 써도 됨 아래것은 기능확장
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(WebBrowserActivity.this, "로딩완료", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.search_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl(mUrlEditText.getText().toString());
            }
        });
        //키보드 이벤트 검출
        mUrlEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    mWebView.loadUrl(mUrlEditText.getText().toString());
                }
                return true;

            }
        });
    }


    //뒤로가기 키 캐치(뒤로가기 누르면 웹뷰가 뒤로가기가 되고 더이상 뒤로 갈 곳이 없으면
    //앱을 닫는다
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            super.onBackPressed();
        }

    }
}
