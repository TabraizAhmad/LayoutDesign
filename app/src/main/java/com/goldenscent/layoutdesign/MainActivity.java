package com.goldenscent.layoutdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.goldenscent.layoutdesign.adapters.LeftColumnAdapter;
import com.goldenscent.layoutdesign.dummyData.LeftColumnData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.leftColumn)
    RecyclerView leftColumn;



    List<LeftColumnData> leftColumnDataList;
    private LeftColumnAdapter leftColumnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLeftData();
        leftColumnAdapter = new LeftColumnAdapter(leftColumnDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        leftColumn.setLayoutManager(mLayoutManager);
        leftColumn.setAdapter(leftColumnAdapter);

    }

    public void initLeftData(){

        leftColumnDataList = new ArrayList<>();
        leftColumnDataList.add(new LeftColumnData("MakeUp",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("SkinCare",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("HairCare",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Gift",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Beauty Tools",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Home Fragnances",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Men",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("MakeUp",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("SkinCare",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("HairCare",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Gift",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Beauty Tools",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Home Fragnances",R.drawable.ic_card_giftcard));
        leftColumnDataList.add(new LeftColumnData("Men",R.drawable.ic_card_giftcard));

    }

}
