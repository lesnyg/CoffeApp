package com.example.edu05.coffeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.MemoAdapter;
import models.Memo;

public class MemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final int REQUEST_CODE_NEW_MEMO = 1000;
    public static final int REQUEST_CODE_UPDATE_MEMO = 1001;

    private List<Memo> mMemoList;
    private MemoAdapter mAdapter;
    private ListView mMemoListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        mMemoListView = findViewById(R.id.memo_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemoActivity.this,Memo2Activity.class);
                startActivityForResult(intent, REQUEST_CODE_NEW_MEMO);
            }
        });

        //데이터
        mMemoList = new ArrayList<>();

        //어댑터
        mAdapter = new MemoAdapter(mMemoList);

        mMemoListView.setAdapter(mAdapter);

        //이벤트
        mMemoListView.setOnItemClickListener(this);

        //ContextMenu
        registerForContextMenu(mMemoListView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");


            if (requestCode == REQUEST_CODE_NEW_MEMO) {
                //새메모
                mMemoList.add(new Memo(title, content));
            } else if (requestCode == REQUEST_CODE_UPDATE_MEMO) {
                Memo memo = mMemoList.get((int)id);
                memo.setTitle(title);
                memo.setContent(content);
            }

            mAdapter.notifyDataSetChanged();

            Toast.makeText(this, "저장 되었습니다", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "취소 되었습니다", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_memo, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                //삭제를 누르면 확인을 받고 싶다
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("확인");
                builder.setMessage("정말로 삭제하시겠습니까?");
                builder.setIcon(R.mipmap.ic_launcher);
                //긍정버튼
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteMemo(info.id);
                    }
                });
                //부정버튼
                builder.setNegativeButton("취소",null);
                builder.show();

                return true;
            case R.id.action_custom_dialog:
                showCustomDialog();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showCustomDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_login,null,false);
        final EditText idEditText = findViewById(R.id.id_edit);
        final EditText passWordEditText = findViewById(R.id.password_edit);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage("정말로 삭제하시겠습니까?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String id = idEditText.getText().toString();
                String pass = passWordEditText.getText().toString();

                Toast.makeText(MemoActivity.this, "ID : "+id+" , password : "+pass, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소",null);
        builder.setView(view);
        builder.show();

    }

    private void deleteMemo(long id) {
        mMemoList.remove((int)id);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Memo memo = mMemoList.get(position);

        Intent intent = new Intent(this,Memo2Activity.class);
        intent.putExtra("id",id);
        intent.putExtra("memo",memo);

        startActivityForResult(intent,REQUEST_CODE_UPDATE_MEMO);
    }
}

