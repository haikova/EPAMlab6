package com.example.olya.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentTwo extends Fragment {


    private List<Cartoon> cartoons;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        initializeData();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerAdapter adapter = new RecyclerAdapter(cartoons);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void initializeData() {
        cartoons = new ArrayList<>();
        cartoons.add(new Cartoon("Beauty and the Beast", R.drawable.img01));
        cartoons.add(new Cartoon("Pocahontas", R.drawable.img02));
        cartoons.add(new Cartoon("Mulan", R.drawable.img03));
        cartoons.add(new Cartoon("The Little Mermaid", R.drawable.img04));
        cartoons.add(new Cartoon("Hercules", R.drawable.img05));
        cartoons.add(new Cartoon("The Lion King", R.drawable.img06));
        cartoons.add(new Cartoon("Alice in Wonderland", R.drawable.img07));
        cartoons.add(new Cartoon("The Hunchback of Notre Dame", R.drawable.img08));
        cartoons.add(new Cartoon("Cinderella", R.drawable.img09));
        cartoons.add(new Cartoon("Peter Pan", R.drawable.img10));
    }
}