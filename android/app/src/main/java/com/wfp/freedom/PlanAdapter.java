package com.wfp.freedom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wfp.slide.slide.SlideBaseAdapter;
import com.wfp.slide.slide.SlideColumnWrap;
import com.wfp.slide.slide.SlideData;

import java.util.List;

public class PlanAdapter extends SlideBaseAdapter {
	public PlanAdapter(Context context) {
		super(context);
	}

	public PlanAdapter(Context context, SlideData data) {
		super(context, data);
	}

	@Override
	public int getItemViewHeight() {
		return (int) mContext.getResources().getDimension(R.dimen.item_height);
	}

	@Override
	public LinearLayout.LayoutParams getColumnWidth(int position, int columnIndex, int columnCount) {
		if (columnIndex < mSlideColumnStart) {
			return new LinearLayout.LayoutParams((int) mContext.getResources().getDimension(R.dimen.item_fixed_column_width),
												 ViewGroup.LayoutParams.MATCH_PARENT);
		} else {
			return new LinearLayout.LayoutParams((int) mContext.getResources().getDimension(R.dimen.item_slide_column_width),
												 ViewGroup.LayoutParams.MATCH_PARENT);

		}
	}


	@Override
	public View getFixedColumnView(int position, int columnIndex, int columnCount, LinearLayout fixedColumnLayout) {
		return LayoutInflater.from(mContext).inflate(R.layout.item_draggable_fixed_column_cell, fixedColumnLayout, false);
	}

	@Override
	public View getSlideColumnView(int position, int columnIndex, int columnCount, SlideColumnWrap slideColumnLayout) {
		return LayoutInflater.from(mContext).inflate(R.layout.item_draggable_slide_column_cell, slideColumnLayout, false);
	}

	@Override
	public void convertColumnViewData(int position,
									  int columnIndex,
									  View columnView,
									  View rowView,
									  String columnData,
									  List<String> columnDataList) {
		String columnText = columnDataList.get(columnIndex);
		if (columnIndex < mSlideColumnStart) {
			TextView textView = (TextView) columnView.findViewById(R.id.text_fixed_cell_item);
			textView.setText(columnText);
		} else {
			TextView textView = (TextView) columnView.findViewById(R.id.text_slide_cell_item);
			textView.setText(columnText);
		}
	}

	@Override
	public void setOnclickListener(View view, List<String> data) {
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("wfp", "PlanAdapter");
			}
		});
	}
}
