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
public class MiscFragment extends Fragment {


    public MiscFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site(getString(R.string.natural_history_name),
                getString(R.string.natural_history_phone),
                getString(R.string.natural_history_address),
                getString(R.string.natural_history_description),
                R.drawable.natural_history));

        sites.add(new Site(getString(R.string.fine_arts_name),
                getString(R.string.fine_arts_phone),
                getString(R.string.fine_arts_address),
                getString(R.string.fine_arts_description),
                R.drawable.fine_arts));

        sites.add(new Site(getString(R.string.leonardo_name),
                getString(R.string.leonardo_phone),
                getString(R.string.leonardo_address),
                getString(R.string.leonardo_description),
                R.drawable.leonardo));

        sites.add(new Site(getString(R.string.off_broadway_name),
                getString(R.string.off_broadway_phone),
                getString(R.string.off_broadway_address),
                getString(R.string.off_broadway_description),
                R.drawable.off_broadway));

        SiteAdapter siteAdapter = new SiteAdapter(getActivity(), sites);
        ListView listView = (ListView) rootView.findViewById(R.id.item_list);
        listView.setAdapter(siteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyApplication.setTabPosition(3);
                Intent intent = MainActivity.buildDetailsIntent(i, sites, getActivity());
                startActivity(intent);
            }
        });



        return rootView;
    }


}
