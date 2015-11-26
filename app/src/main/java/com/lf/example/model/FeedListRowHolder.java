package com.lf.example.model;

/**
 * Created by krishna on 11/26/15.
 */
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lf.example.R;

public class FeedListRowHolder extends RecyclerView.ViewHolder {
    public ImageView thumbnail;
    public TextView title;

    public FeedListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }

}
