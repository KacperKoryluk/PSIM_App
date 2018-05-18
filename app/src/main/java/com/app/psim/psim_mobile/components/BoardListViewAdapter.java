package com.app.psim.psim_mobile.components;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.app.psim.psim_mobile.Post;
import com.app.psim.psim_mobile.R;

import java.util.List;

/**
 * Created by Xemur on 01.05.2018.
 */

public class BoardListViewAdapter extends ArrayAdapter<Post> {

    public BoardListViewAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public BoardListViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Post> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.view_board_post, null);
            Log.println(Log.DEBUG, "DEBUG", "View Created");

            Animation animation = AnimationUtils
                    .loadAnimation(getContext(), R.anim.post_zoomin);
            view.startAnimation(animation);
        }
        Post item = getItem(position);

        if (item != null) {
            TextView title = view.findViewById(R.id.view_post_title);
            TextView desc = view.findViewById(R.id.view_post_descbrief);
            TextView author = view.findViewById(R.id.view_post_author);
            title.setText(item.Title);
            desc.setText(item.Description);
            author.setText("By " + item.Author);
            Log.println(Log.DEBUG, "DEBUG", "Item " + item.Title + " Connected");

        }
        Log.println(Log.DEBUG, "DEBUG", position + "Returned");

        return view;
    }
}
