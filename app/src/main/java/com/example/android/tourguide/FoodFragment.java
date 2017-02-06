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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.site_list, container, false);

        final ArrayList<Site> sites = new ArrayList<>();
        sites.add(new Site(getString(R.string.settebello_name),
                getString(R.string.settebello_phone),
                getString(R.string.settebello_address),
                getString(R.string.settebello_description)));

        sites.add(new Site(getString(R.string.bambara_name),
                getString(R.string.bambara_phone),
                getString(R.string.bambara_address),
                getString(R.string.bambara_description)));

        sites.add(new Site(getString(R.string.brio_name),
                getString(R.string.brio_phone),
                getString(R.string.brio_address),
                getString(R.string.brio_description)));

        sites.add(new Site(getString(R.string.copper_onion_name),
                getString(R.string.copper_onion_phone),
                getString(R.string.copper_onion_address),
                getString(R.string.copper_onion_description)));

        sites.add(new Site(getString(R.string.blue_lemon_name),
                getString(R.string.blue_lemon_phone),
                getString(R.string.blue_lemon_address),
                getString(R.string.blue_lemon_description)));

        sites.add(new Site(getString(R.string.molise_name),
                getString(R.string.molise_phone),
                getString(R.string.molise_address),
                getString(R.string.molise_description)));

        sites.add(new Site(getString(R.string.blue_iguana_name),
                getString(R.string.blue_iguana_phone),
                getString(R.string.blue_iguana_address),
                getString(R.string.blue_iguana_description)));

        sites.add(new Site(getString(R.string.takashi_name),
                getString(R.string.takashi_phone),
                getString(R.string.takashi_address),
                getString(R.string.takashi_description)));

        sites.add(new Site(getString(R.string.eva_name),
                getString(R.string.eva_phone),
                getString(R.string.eva_address),
                getString(R.string.eva_description)));

        sites.add(new Site(getString(R.string.red_rock_name),
                getString(R.string.red_rock_phone),
                getString(R.string.red_rock_address),
                getString(R.string.red_rock_description)));


        SiteAdapter siteAdapter = new SiteAdapter(getActivity(), sites);
        ListView listView = (ListView) rootView.findViewById(R.id.item_list);
        listView.setAdapter(siteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyApplication.setTabPosition(0);
                Intent intent = MainActivity.buildDetailsIntent(i, sites, getActivity());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
