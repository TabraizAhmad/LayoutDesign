package com.goldenscent.layoutdesign.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
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

public class LeftColumnAdapter extends RecyclerView.Adapter<LeftColumnAdapter.LeftColumnViewHolder> implements View.OnClickListener {

    private List<LeftColumnData> leftColumnDataList;
    Context mContext;
    public LeftColumnAdapter(List<LeftColumnData> leftColumnDataList,Context context) {
        this.leftColumnDataList = leftColumnDataList;
        mContext = context;

    }

    @NonNull
    @Override
    public LeftColumnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_left_menu, parent, false);
        itemView.setOnClickListener(this);
        return new LeftColumnAdapter.LeftColumnViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull LeftColumnViewHolder holder, int position) {
        LeftColumnData dummyData = leftColumnDataList.get(position);
        holder.itemIcon.setImageResource(dummyData.getResId());
        holder.itemName.setText(dummyData.getName());
        holder.itemView.setTag(position);
        if(dummyData.isSelected()){
            holder.cardViewLayout.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bottom_border));
        }else{
            holder.cardViewLayout.setBackground(null);
        }
    }

    @Override
    public int getItemCount() {
        return leftColumnDataList.size();
    }

    @Override
    public void onClick(View v) {
        removeSelected();
        int currentPosition = (int) v.getTag();
        leftColumnDataList.get(currentPosition).setSelected(true);
        notifyDataSetChanged();
    }

    private void removeSelected() {
        for (LeftColumnData dummyData: leftColumnDataList) {
            if (dummyData.isSelected())
                dummyData.setSelected(false);
        }
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
