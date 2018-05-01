package com.app.psim.psim_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.app.psim.psim_mobile.components.BoardListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    private ListView postListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //TODO: Remove debug and implement downloading post headers from server
        //DEBUG
        List<Post> list = new ArrayList<Post>();
        list.add(new Post("Kappa", null, "I can read sumthing", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Przeciez to sie nie godzi by tak bylo", null, "This text must be very long so i can check if the maximum height property is doing it's work. Please be patient. Somebody once told me that you have a boyfriend that looks like a girlfriend that i had in february of lat year. Please be patient. Somebody once told me that you have a boyfriend that looks like a girlfriend that i had in february of lat year.", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        list.add(new Post("Hekken Mekken", null, "Das is a nice description", "", "Xemur"));
        //END DEBUG

        postListView = (ListView)findViewById(R.id.postListView);
        BoardListViewAdapter adapter = new BoardListViewAdapter(this, R.layout.view_board_post, list);
        postListView.setAdapter(adapter);
    }
}
