package com.goldenscent.layoutdesign.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.goldenscent.layoutdesign.R;

import java.util.HashMap;
import java.util.List;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    // Child Items of the List
    private List<String> mListData;
    // Child Items of the individual items of the List
    private HashMap<String, List<String[]>> mListChildData;

    public MyExpandableListAdapter(Context context, List<String> listData,
                                   HashMap<String, List<String[]>> listChildData){
        mContext = context;
        mListData = listData;
        mListChildData = listChildData;
    }

    @Override
    public int getGroupCount() {
        return mListData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mListChildData.get(mListData.get(i)).size() + 1;
    }

    @Override
    public Object getGroup(int i) {
        return mListData.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListChildData.get(mListData.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupId) {
        return groupId;
    }

    @Override
    public long getChildId(int groupId, int childId) {
        return childId;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup viewGroup) {

        TextView headingName;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group_heading, null);
        }

        // Fetching the view and binding the appropriate text to it
        headingName = convertView.findViewById(R.id.headingName);
        headingName.setText(mListData.get(i));
        if (isExpanded) {
            Drawable img = mContext.getResources().getDrawable( R.drawable.ic_arrow_up);
            headingName.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
        } else {
            Drawable img = mContext.getResources().getDrawable( R.drawable.ic_arrow_down);
            headingName.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
        }
        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean isLastChild, View convertView, ViewGroup viewGroup) {


        if(isLastChild) // last element is a Button
        {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_botton, null);
        }else{
            TextView itemOneName;
            TextView itemTwoName;
            TextView itemThreeName;
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_group_items, null);
            itemOneName = convertView.findViewById(R.id.itemOneName);
            itemTwoName = convertView.findViewById(R.id.itemTwoName);
            itemThreeName = convertView.findViewById(R.id.itemThreeName);
            itemOneName.setText(mListChildData.get(mListData.get(i)).get(i1)[0]);
            itemTwoName.setText(mListChildData.get(mListData.get(i)).get(i1)[1]);
            itemThreeName.setText(mListChildData.get(mListData.get(i)).get(i1)[2]);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        // Don't forget to set this true so that the child items are selectable
        return true;
    }
}