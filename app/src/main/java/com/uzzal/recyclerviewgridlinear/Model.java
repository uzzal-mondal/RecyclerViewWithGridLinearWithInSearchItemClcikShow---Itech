package com.uzzal.recyclerviewgridlinear;

import android.graphics.Bitmap;

import java.util.Comparator;

public class Model {

    private String title, discription;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


            //  iT'S AMAZING ASCENDING WITH DESCENDING ... @


   // Ascending methtod declare..
    public static final Comparator<Model> BY_TITLE_ASCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {

            // ascending.
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    // Ascending methtod declare..
    public static final Comparator<Model> BY_TITLE_DESCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {

            // ascending.
            return o2.getTitle().compareTo(o1.getTitle());
        }
    };
}
