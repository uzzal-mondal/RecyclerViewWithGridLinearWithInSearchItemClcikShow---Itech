package com.uzzal.recyclerviewgridlinear;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //declare view
    ImageView mImageIv;
    TextView mTitleTv, mDiscrTv;
    ItemClcikListner itemClcikListner;


     MyViewHolder(@NonNull View itemView) {
        super(itemView);

        // all times are write to below to the super class.
        this.mImageIv = itemView.findViewById(R.id.imageView_details_id);
        this.mTitleTv = itemView.findViewById(R.id.titleText_details_id);
        this.mDiscrTv = itemView.findViewById(R.id.discripText_details_id);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        this.itemClcikListner.onItemClcik(v, getLayoutPosition());

    }

    public void setItemClcikListner(ItemClcikListner ic){
        this.itemClcikListner = ic;

    }
}
