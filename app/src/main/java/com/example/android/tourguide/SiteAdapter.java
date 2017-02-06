package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by phil.walker on 2/4/17.
 */

public class SiteAdapter extends ArrayAdapter<Site> {

    public SiteAdapter(Context context, List<Site> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Site currentSite = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentSite.getmName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if (currentSite.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentSite.getmImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
