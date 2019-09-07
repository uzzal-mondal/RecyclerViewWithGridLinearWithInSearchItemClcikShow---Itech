package com.uzzal.recyclerviewgridlinear;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    MyAdapter adapter;
    ArrayList<Model> filterList;

    public CustomFilter(ArrayList<Model> filterList, MyAdapter adapter) {

        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();
        // check constant validity..

        if (constraint!=null && constraint.length() > 0){

            // change to upperCase
            constraint = constraint.toString().toUpperCase();
            // store our filtered models.
            ArrayList<Model> filterModels = new ArrayList<>();
            for (int i=0; i<filterList.size(); i++){

                // check now..
                if (filterList.get(i).getTitle().toUpperCase().contains(constraint)){

                    // add model to filter models
                    filterModels.add(filterList.get(i));
                }

                results.count = filterModels.size();
                results.values = filterModels;

            }

        }else {

            results.count = filterList.size();
            results.values = filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.models = (ArrayList<Model>) results.values;

        //refresh your codding
        adapter.notifyDataSetChanged();

    }
}
