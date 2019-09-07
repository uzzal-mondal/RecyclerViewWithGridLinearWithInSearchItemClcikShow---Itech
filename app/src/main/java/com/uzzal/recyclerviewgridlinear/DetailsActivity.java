package com.uzzal.recyclerviewgridlinear;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView detailTitleTv, detailDiscripTv;
    private ImageView detaisIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        ActionBar actionBar = getSupportActionBar();


        detailDiscripTv = findViewById(R.id.discripText_details_id);
        detailTitleTv = findViewById(R.id.titleText_details_id);
        detaisIV = findViewById(R.id.imageView_details_id);


        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("title");
        String mDiscrip = intent.getStringExtra("discrip");
        byte[] mBytes = getIntent().getByteArrayExtra("image");

        // decode bytes array to bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        // set the Tile to Action Bar.
        actionBar.setTitle(mTitle);


        // set data two aour view.
        detailTitleTv.setText(mTitle);
        detailDiscripTv.setText(mDiscrip);
        detaisIV.setImageBitmap(bitmap);




    }
}
