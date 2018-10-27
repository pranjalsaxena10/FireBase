package com.pranjalmohansaxena.firebaseconnection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by HP on 28-10-2018.
 */

public class CardViewHolder extends ViewHolder {
    View view;

    public CardViewHolder(View itemView) {
        super(itemView);
        view=itemView;
    }
    public void settingInformation(Context context, String desc, String title, String value)
    {
        TextView id_title=(TextView) view.findViewById(R.id.title);
        ImageView id_value=(ImageView) view.findViewById(R.id.value);
        TextView id_desc=(TextView) view.findViewById(R.id.desc);
        Picasso.get().load(value).into(id_value);
        id_title.setText(title);
        id_desc.setText(desc);
    }
}
