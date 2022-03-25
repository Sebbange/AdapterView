package com.hansung.android.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    static MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.sample_0, "Bella", "1"));
        data.add(new MyItem(R.drawable.sample_1, "Charlie", "2"));
        data.add(new MyItem(R.drawable.sample_2, "Daisy", "1.5"));
        data.add(new MyItem(R.drawable.sample_3, "Duke", "1"));
        data.add(new MyItem(R.drawable.sample_4, "Max", "2"));
        data.add(new MyItem(R.drawable.sample_5, "Happy", "4"));
        data.add(new MyItem(R.drawable.sample_6, "Luna", "3"));
        data.add(new MyItem(R.drawable.sample_7, "Bob", "2"));

        //어댑터 생성
        adapter = new MyAdapter(this, R.layout.item, data);

        //어댑터 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}