package com.uzzal.recyclerviewgridlinear;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
// must be decalre to support.v7.widget.SearchView
//import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Shared preference
        pref = this.getSharedPreferences("MY_Data", MODE_PRIVATE);

        // recycler view find.
        recyclerView = findViewById(R.id.recyclerView_id);

        showData();




//        //set the properties.
//        // LinearLayout with Grid Layout manager.
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//
//
//        myAdapter = new MyAdapter(this, showData());
//        recyclerView.setAdapter(myAdapter);

    }

    // add model to arrayList. in mainActivity...
    private void showData() {

        ArrayList<Model> models = new ArrayList<>();

        Model d = new Model();
        d.setTitle("Dart");
        d.setDiscription("Dart is Fluter Art. This is developed by Google, Now it's very familar to world.");
        d.setImage(R.drawable.dartlogo);
        models.add(d);

        Model f = new Model();
        f.setTitle("Fluter");
        f.setDiscription("Fluter is wonderfull crossplatform app invention. This is developed by Google, Now it's very familar to world.");
        f.setImage(R.drawable.fluterlogo);
        models.add(f);

        Model j = new Model();
        j.setTitle("Java");
        j.setDiscription("Java is OOP Best. This is developed by Oracle, Now it's very familar to world.");
        j.setImage(R.drawable.javalogo);
        models.add(j);

        Model js = new Model();
        js.setTitle("Java Script");
        js.setDiscription("Java Script is Wonderfull language. This is developed by Google, Now it's very familar to world.");
        js.setImage(R.drawable.javascriptlogo);
        models.add(js);

        Model k = new Model();
        k.setTitle("kotlin");
        k.setDiscription("Kotlin is kidding programming language.. This is developed by Google, Now it's very familar to world.");
        k.setImage(R.drawable.kotlinlogo);
        models.add(k);

        Model py = new Model();
        py.setTitle("Python");
        py.setDiscription("Python is Deep Learning Language. This is developed by Google, Now it's very familar to world.");
        py.setImage(R.drawable.pythonlogo);
        models.add(py);

        Model ph = new Model();
        ph.setTitle("PHP");
        ph.setDiscription("Php is Best Server site Programming Learning Language. This is developed by Google, Now it's very familar to world.");
        ph.setImage(R.drawable.phplogo);
        models.add(ph);


        // get string form shared preference or short opetion.

        String mShortString = pref.getString("Sort","Ascending"); // ascendign menas its default setting.
        if(mShortString.equals("Ascending")){
            Collections.sort(models, Model.BY_TITLE_ASCENDING);

        }

        else  if(mShortString.equals("Descending")){

            Collections.sort(models, Model.BY_TITLE_DESCENDING);
        }



        //set the properties.
        // LinearLayout with Grid Layout manager.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        // set recycler view properties.
        myAdapter = new MyAdapter(this, models);
        recyclerView.setAdapter(myAdapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // called whenever you click to search.
                myAdapter.getFilter().filter(query);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //cakked when ever you type each letter search view.

                myAdapter.getFilter().filter(newText);


                return false;
            }
        });

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_short){

            showShortDaiLog();
        }

        return super.onOptionsItemSelected(item);
    }

    public void showShortDaiLog(){

        // options two display in dialog.
        String[] options  = {"Ascending" , "Descending"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort By");

        builder.setIcon(R.drawable.ic_action_sort);


        // dailog interface OnClickListner..
       builder.setItems(options, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

              if(which==0){  // Assending is click.

                  SharedPreferences.Editor editor = pref.edit();
                  editor.putString("Short","Ascending"); // where is short key ascending is value.
                  editor.apply();
                  showData();

              }

              if (which == 1){  // Descending is clcik.

                  SharedPreferences.Editor editor = pref.edit();
                  editor.putString("Short","Descending");
                  editor.apply();
                  showData();

              }

           }
       });

       builder.create().show();

    }
}
