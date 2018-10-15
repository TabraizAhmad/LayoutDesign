package com.goldenscent.layoutdesign.adapters;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.goldenscent.layoutdesign.R;
import com.goldenscent.layoutdesign.dummyData.LeftColumnData;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LeftColumnAdapter extends RecyclerView.Adapter<LeftColumnAdapter.LeftColumnViewHolder> {

    private List<LeftColumnData> leftColumnDataList;
    public LeftColumnAdapter(List<LeftColumnData> leftColumnDataList) {
        this.leftColumnDataList = leftColumnDataList;
    }

    @NonNull
    @Override
    public LeftColumnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_left_menu, parent, false);
        return new LeftColumnAdapter.LeftColumnViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull LeftColumnViewHolder holder, int position) {
        LeftColumnData dummyData = leftColumnDataList.get(position);
        holder.itemIcon.setImageResource(dummyData.getResId());
        holder.itemName.setText(dummyData.getName());
        
    }

    @Override
    public int getItemCount() {
        return leftColumnDataList.size();
    }

    class LeftColumnViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardViewLayout)
        LinearLayout cardViewLayout;

        @BindView(R.id.itemIcon)
        ImageView itemIcon;
        @BindView(R.id.itemName)
        TextView itemName;

        LeftColumnViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
