package com.chute.android.photopickerplus.util;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chute.android.photopickerplus.R;

public class UIUtil {

	public static void setServiceFragmentLabel(Context context,
			TextView textView, boolean supportImages, boolean supportVideos) {
		if (supportImages == true && supportVideos == false) {
			textView.setText(context.getResources().getString(
					R.string.select_photo_source));
		} else if (supportVideos == true && supportImages == false) {
			textView.setText(context.getResources().getString(
					R.string.select_video_source));
		} else {
			textView.setText(context.getResources().getString(
					R.string.select_media_source));
		}
	}

	public static GridView initGridView(Context context) {
		GridView grid = new GridView(context);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, R.id.gcTextViewSelectMedia);
		params.addRule(RelativeLayout.ABOVE, R.id.gcLinearLayoutButtons);
		grid.setLayoutParams(params);
		grid.setFadingEdgeLength(0);
		grid.setFastScrollEnabled(true);
		grid.setHorizontalSpacing(10);
		grid.setPadding(20, 10, 20, 0);
		grid.setVerticalScrollBarEnabled(false);
		grid.setHorizontalScrollBarEnabled(false);
		grid.setVerticalSpacing(10);
		grid.setNumColumns(context.getResources().getInteger(
				R.integer.grid_columns_assets));
		return grid;
	}

	public static ListView initListView(Context context) {
		ListView list = new ListView(context);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, R.id.gcTextViewSelectMedia);
		params.addRule(RelativeLayout.ABOVE, R.id.gcLinearLayoutButtons);
		list.setLayoutParams(params);
		list.setFadingEdgeLength(0);
		list.setFastScrollEnabled(true);
		list.setVerticalScrollBarEnabled(false);
		list.setHorizontalScrollBarEnabled(false);
		list.setPadding(0, 10, 0, 0);
		return list;
	}

	public static void setFragmentLabel(Context context, TextView textView,
			boolean supportImages, boolean supportVideos, boolean isMultipicker) {
		if (isMultipicker == true) {
			if (supportImages == true && supportVideos == false) {
				textView.setText(context.getResources().getString(
						R.string.select_photos));
			} else if (supportVideos == true && supportImages == false) {
				textView.setText(context.getResources().getString(
						R.string.select_videos));
			} else {
				textView.setText(context.getResources().getString(
						R.string.select_media));
			}
		} else {
			if (supportImages == true && supportVideos == false) {
				textView.setText(context.getResources().getString(
						R.string.select_a_photo));
			} else if (supportVideos == true && supportImages == false) {
				textView.setText(context.getResources().getString(
						R.string.select_a_video));
			} else {
				textView.setText(context.getResources().getString(
						R.string.select_media));
			}
		}
	}

}
