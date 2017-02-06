package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheatreFragment extends Fragment {


    public TheatreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.site_list, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site(getString(R.string.capitol_theatre_name),
                getString(R.string.capitol_theatre_phone),
                getString(R.string.capitol_theatre_address),
                getString(R.string.capitol_theatre_description)));

        sites.add(new Site(getString(R.string.eccles_theatre_name),
                getString(R.string.eccles_theatre_phone),
                getString(R.string.eccles_theatre_address),
                getString(R.string.no_description_given)));

        sites.add(new Site(getString(R.string.tower_theatre_name),
                getString(R.string.tower_theatre_phone),
                getString(R.string.tower_theatre_address),
                getString(R.string.tower_theatre_description)));

        sites.add(new Site(getString(R.string.broadway_name),
                getString(R.string.broadway_phone),
                getString(R.string.broadway_address),
                getString(R.string.broadway_description)));

        sites.add(new Site(getString(R.string.pioneer_name),
                getString(R.string.pioneer_phone),
                getString(R.string.pioneer_address),
                getString(R.string.pioneer_description)));

        sites.add(new Site(getString(R.string.rose_wagner_name),
                getString(R.string.rose_wagner_phone),
                getString(R.string.rose_wagner_address),
                getString(R.string.rose_wagner_description)));

        sites.add(new Site(getString(R.string.grand_theatre_name),
                getString(R.string.grand_theatre_phone),
                getString(R.string.grand_theatre_address),
                getString(R.string.grand_theatre_description)));

        SiteAdapter siteAdapter = new SiteAdapter(getActivity(), sites);
        ListView listView = (ListView) rootView.findViewById(R.id.item_list);
        listView.setAdapter(siteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyApplication.setTabPosition(1);
                Intent intent = MainActivity.buildDetailsIntent(i, sites, getActivity());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
