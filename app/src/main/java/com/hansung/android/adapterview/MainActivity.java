package com.hansung.android.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem("리눅스\n시스템프로그래밍", "월18:00~19:25","공학관407"));
        data.add(new MyItem("데이터통신", "화18:00~19:00","온라인"));
        data.add(new MyItem("보안\n프로그래밍", "화21:00~22:00","온라인"));
        data.add(new MyItem("자료구조", "수18:00~19:25","공학관408"));
        data.add(new MyItem("안드로이드\n프로그래밍", "수19:25~21:00","공학관314"));
        data.add(new MyItem("오픈소스\n임베디드OS", "목19:25~21:00","상상관505"));

        //어댑터 생성
        adapter = new MyAdapter(this, R.layout.item, data);

        //어댑터 연결
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setDivider(new ColorDrawable(Color.RED));
        listView.setDividerHeight(5);

        //어댑터 이벤트처리-아이템(리스트)가 클릭되면
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                String name = ((MyItem) adapter.getItem(position)).mClassName; //과목이름을 출력해줌
                Toast.makeText(MainActivity.this, name + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}