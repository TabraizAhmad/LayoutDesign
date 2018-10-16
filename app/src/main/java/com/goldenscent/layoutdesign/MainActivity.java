package com.goldenscent.layoutdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.goldenscent.layoutdesign.adapters.BestSellerAdapter;
import com.goldenscent.layoutdesign.adapters.LeftColumnAdapter;
import com.goldenscent.layoutdesign.decorater.DividerItemDecoration;
import com.goldenscent.layoutdesign.dummyData.BestSellerData;
import com.goldenscent.layoutdesign.dummyData.LeftColumnData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.leftColumn)
    RecyclerView leftColumn;

    @BindView(R.id.bestSellerRecyclerView)
    RecyclerView bestSellerRecyclerView;


    List<LeftColumnData> leftColumnDataList;
    private LeftColumnAdapter leftColumnAdapter;

    BestSellerAdapter bestSellerAdapter;
    List<BestSellerData> bestSellerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLeftData();
        leftColumnAdapter = new LeftColumnAdapter(leftColumnDataList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        leftColumn.setLayoutManager(mLayoutManager);
        leftColumn.setAdapter(leftColumnAdapter);

        initBestSellerData();
        bestSellerAdapter = new BestSellerAdapter(bestSellerData);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3,GridLayoutManager.HORIZONTAL,false);
        bestSellerRecyclerView.setLayoutManager(gridLayoutManager);
        bestSellerRecyclerView.addItemDecoration(new DividerItemDecoration(bestSellerRecyclerView.getContext()));

        bestSellerRecyclerView.setAdapter(bestSellerAdapter);
        SnapHelper startSnapHelper = new LinearSnapHelper();
        startSnapHelper.attachToRecyclerView(bestSellerRecyclerView);

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
        leftColumnDataList.get(0).setSelected(true);

    }

    public void initBestSellerData(){

        bestSellerData = new ArrayList<>();
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","250",""));
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","450",""));
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","600","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","356",""));
        bestSellerData.add(new BestSellerData("Parada","Candy","800","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));
        bestSellerData.add(new BestSellerData("Parada","Candy","356",""));
        bestSellerData.add(new BestSellerData("Parada","Candy","356","320"));

    }

}
