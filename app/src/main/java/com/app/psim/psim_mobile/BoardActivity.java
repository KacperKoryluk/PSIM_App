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
import java.util.Arrays;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    private ListView postListView;
    private ArrayList<Post> postList;
    private BoardListViewAdapter postListAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean displaysSearchResults = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        postList = (ArrayList<Post>)DataManager.Singleton().GetPosts();

        postListView = (ListView)findViewById(R.id.board_postListView);
        postListAdapter = new BoardListViewAdapter(this, R.layout.view_board_post, postList);
        postListView.setAdapter(postListAdapter);
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
                                startActivityForResult(intent, 1);
                                return true;
                            case R.id.drawer_search:
                                intent = new Intent(getBaseContext(), BrowseActivity.class);
                                startActivityForResult(intent, 2);
                                return true;
                        }
                        return false;
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

    @Override
    public void onBackPressed() {
        if(displaysSearchResults == true)
        {
            displaysSearchResults = false;
            List<Post> posts = DataManager.Singleton().GetPosts();
            postList.clear();
            postList.addAll(posts);
            postListAdapter.notifyDataSetChanged();
        }
        else
            super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Post post = data.getParcelableExtra("created_post_data");
            DataManager.Singleton().AddPost(post);
            postList.add(post);
            postListAdapter.notifyDataSetChanged();
        }
        if(requestCode == 2 && resultCode == RESULT_OK)
        {
            displaysSearchResults = true;
            String tags = data.getStringExtra("tags_data");
            List<String> tagList = new ArrayList<String>(Arrays.asList(tags.split("[ #]")));
            List<Post> posts = DataManager.Singleton().GetPosts(tagList);
            postList.clear();
            postList.addAll(posts);
            postListAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
