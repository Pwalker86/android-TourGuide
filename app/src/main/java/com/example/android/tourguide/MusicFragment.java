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
public class MusicFragment extends Fragment {


    public MusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site(getString(R.string.kilby_name),
                getString(R.string.kilby_phone),
                getString(R.string.kilby_address),
                getString(R.string.kilby_description)));

        sites.add(new Site(getString(R.string.state_room_name),
                getString(R.string.state_room_phone),
                getString(R.string.state_room_address),
                getString(R.string.state_room_description)));

        sites.add(new Site(getString(R.string.in_the_venue_name),
                getString(R.string.in_the_venue_phone),
                getString(R.string.in_the_venue_address),
                getString(R.string.no_description_given)));

        sites.add(new Site(getString(R.string.depot_name),
                getString(R.string.depot_phone),
                getString(R.string.depot_address),
                getString(R.string.depot_description)));

        sites.add(new Site(getString(R.string.urban_lounge_name),
                getString(R.string.urban_lounge_phone),
                getString(R.string.urban_lounge_address),
                getString(R.string.urban_lounge_description)));

        sites.add(new Site(getString(R.string.garage_name),
                getString(R.string.garage_phone),
                getString(R.string.address),
                getString(R.string.garage_description)));

        sites.add(new Site(getString(R.string.shred_shed_name),
                getString(R.string.shred_shed_phone),
                getString(R.string.shred_shed_address),
                getString(R.string.no_description_given)));

        SiteAdapter siteAdapter = new SiteAdapter(getActivity(), sites);
        ListView listView = (ListView) rootView.findViewById(R.id.item_list);
        listView.setAdapter(siteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyApplication.setTabPosition(2);
                Intent intent = MainActivity.buildDetailsIntent(i, sites, getActivity());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
