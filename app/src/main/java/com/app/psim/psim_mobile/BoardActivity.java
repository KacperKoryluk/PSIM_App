package com.app.psim.psim_mobile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.app.psim.psim_mobile.components.BoardListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    private ListView postListView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

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


        postListView = (ListView)findViewById(R.id.board_postListView);
        BoardListViewAdapter adapter = new BoardListViewAdapter(this, R.layout.view_board_post, list);
        postListView.setAdapter(adapter);
        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        Toolbar toolbar = findViewById(R.id.board_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.board_drawer);
        navigationView = findViewById(R.id.board_navigationView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        drawerLayout.closeDrawers();
                        Intent intent = null;
                        switch (item.getItemId())
                        {
                            case R.id.drawer_addpost:
                                intent = new Intent(getBaseContext(), AddContentActivity.class);
                                break;
                            case R.id.drawer_search:
                                intent = new Intent(getBaseContext(), BrowseActivity.class);
                                break;
                        }
                        if(intent != null)
                            startActivity(intent);
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
