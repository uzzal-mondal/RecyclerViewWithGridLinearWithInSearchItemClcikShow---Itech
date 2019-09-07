package com.uzzal.recyclerviewgridlinear;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {

    Context context;
    ArrayList<Model> models, filterList;
    CustomFilter filter;


    public MyAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
        this.filterList = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
       View view =  inflater.inflate(R.layout.model,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {

        // Bind data to our views..
        myViewHolder.mTitleTv.setText(models.get(position).getTitle());
        myViewHolder.mDiscrTv.setText(models.get(position).getDiscription());
        myViewHolder.mImageIv.setImageResource(models.get(position).getImage());

        //Animation are create OnBindViewHolder method.
        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        myViewHolder.itemView.startAnimation(animation);

        // use when you want to to put each item data to same activty


        myViewHolder.setItemClcikListner(new ItemClcikListner() {
            @Override
            public void onItemClcik(View view, int position) {

                /*get data from item clciked..*/
                String title  = models.get(position).getTitle();
                String discrip = models.get(position).getDiscription();

                // janina data passi image er .
                BitmapDrawable bitmapDrawable = (BitmapDrawable) myViewHolder.mImageIv.getDrawable();

                // get Bitmap for drawable.
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream =  new ByteArrayOutputStream();

                 //   compress imagese
                 bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);

                 //convert to Buyte array
                byte[] bytes = stream.toByteArray();

                // intent put data to Intent , start activity
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("discrip", discrip);
                intent.putExtra("image", bytes);
                context.startActivity(intent);



            }
        });


        // use when you want to to put each item data to same activty

//        myViewHolder.setItemClcikListner(new ItemClcikListner() {
//            @Override
//            public void onItemClcik(View view, int position) {
//
//                if (models.get(position).getTitle().equals("Dart")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//                if (models.get(position).getTitle().equals("Fluter")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//                if (models.get(position).getTitle().equals("Java")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//
//                if (models.get(position).getTitle().equals("Java Script")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//
//                if (models.get(position).getTitle().equals("kotlin")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//                if (models.get(position).getTitle().equals("Python")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//                if (models.get(position).getTitle().equals("PHP")){
//
//                    // do something when item with title dart is clicked
//
//                }
//
//                //you can use any of these two methods accroding to your needs.
//
//
//
//
//
//
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {

        if (filter == null){

            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }



}
