package com.app.psim.psim_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddContentActivity extends AppCompatActivity {

    private Button ready;
    private EditText title;
    private EditText tags;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.editText2);
        tags = findViewById(R.id.editText3);
        description = findViewById(R.id.editText4);

        ready = findViewById(R.id.button2);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> tagList = new ArrayList<String>();
                //TODO: Split tags to pieces before adding
                tagList.add(tags.getText().toString());
                setResult(RESULT_OK, new Intent()
                        .putExtra("created_post_data", new Post(title.getText().toString(), tagList, description.getText().toString(),"", "User")));
                finish();
            }
        });
    }

}
