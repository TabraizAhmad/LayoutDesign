package com.goldenscent.layoutdesign.adapters;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.goldenscent.layoutdesign.R;
import com.goldenscent.layoutdesign.dummyData.BestSellerData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.BestSellerCellHolder> {

    private List<BestSellerData> bestSellerData;
    public BestSellerAdapter(List<BestSellerData> leftColumnDataList) {
        this.bestSellerData = leftColumnDataList;
    }

    @NonNull
    @Override
    public BestSellerCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_best_seller, parent, false);
        return new BestSellerCellHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerCellHolder holder, int position) {
        BestSellerData dummyData = bestSellerData.get(position);
        holder.firstItemImage.setImageResource(R.drawable.best_seller);
        holder.firstItemBrand.setText(dummyData.getFirstItemBrand());
        holder.firstItemDescription.setText(dummyData.getFirstItemDescription());
        holder.firstItemPrice.setText(dummyData.getFirstItemPrice());
        if(dummyData.getReducedPrice().length()>0){
            holder.firstItemPrice.setPaintFlags(holder.firstItemPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.reducedPrice.setText(dummyData.getReducedPrice());
        }


    }

    @Override
    public int getItemCount() {
        return bestSellerData.size();
    }

    class BestSellerCellHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.firstItemImage)
        ImageView firstItemImage;
        @BindView(R.id.firstItemBrand)
        TextView firstItemBrand;
        @BindView(R.id.firstItemDescription)
        TextView firstItemDescription;

        @BindView(R.id.firstItemPrice)
        TextView firstItemPrice;
        @BindView(R.id.reducedPrice)
        TextView reducedPrice;

        BestSellerCellHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
