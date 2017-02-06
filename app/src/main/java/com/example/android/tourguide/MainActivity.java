package com.example.android.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int tabPosition = MyApplication.getTabPosition();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        SiteFragmentPagerAdapter adapter = new SiteFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout.Tab tab = tabLayout.getTabAt(tabPosition);
        tab.select();
    }

    static void populateDetails(Bundle extras, Activity activity) {

        TextView nameTextView = (TextView) activity.findViewById(R.id.name_text_view);
        nameTextView.setText(extras.getString("name"));

        TextView phoneTextView = (TextView) activity.findViewById(R.id.phone_text_view);
        phoneTextView.setText(extras.getString("phone"));

        TextView addressTextView = (TextView) activity.findViewById(R.id.address_text_view);
        addressTextView.setText(extras.getString("address"));

        TextView descriptionTextView = (TextView) activity.findViewById(R.id.description_text_view);
        descriptionTextView.setText(extras.getString("description"));

        ImageView imageView = (ImageView) activity.findViewById(R.id.image_view);
        if (extras.get("imageId") != null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(extras.getInt("imageId"));
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    static Intent buildDetailsIntent(int position, ArrayList<Site> sites, Activity startingActivity) {
        Site site = sites.get(position);
        Intent intent = new Intent(startingActivity, DetailActivity.class);
        intent.putExtra("name", site.getmName());
        intent.putExtra("phone", site.getmPhone());
        intent.putExtra("address", site.getmAddress());
        intent.putExtra("description", site.getmDescription());
        if (site.hasImage()) {
            intent.putExtra("imageId", site.getmImageResourceId());
        }
        return intent;
    }
}
