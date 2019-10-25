package com.example.mymetroticketbooking;

import android.os.Bundle;

import com.example.mymetroticketbooking.adapter.MyImageTextAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
   //     SearchView.OnQueryTextListener
{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int []images;
    private List<String> nameList , detailsList;
    MyImageTextAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.id_main_app_bar);
        setSupportActionBar(toolbar);


        initilization();
        addPhotos();
    }

    private void addPhotos() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void initilization() {

        recyclerView = findViewById(R.id.recycle_view);
        layoutManager= new GridLayoutManager(this , 2);

        images = new int[]{R.mipmap.routes , R.mipmap.journey_planner,
        R.mipmap.metro_map , R.mipmap.nearby_stations};

        nameList = Arrays.asList("Routes" , "Journey Planner", "Metro Map", "Nearby Station");

        detailsList = Arrays.asList("Find route by line" , "Plan your journey"
        ,"View routes on map", "Nearby metro stations");

        adapter = new MyImageTextAdapter(images ,nameList ,detailsList);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_act_menu ,menu);
//
//        MenuItem menuItem = menu.findItem(R.id.id_search_menu);
//        SearchView searchView = (SearchView)menuItem.getActionView();
//        searchView.setOnQueryTextListener(this);

        return true;
    }

//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }

//    @Override
//    public boolean onQueryTextChange(String newText) {
//        String userInput = newText.toLowerCase();
//        List<String>newList = new ArrayList<>();
//
//        for(String name : newList)
//        {
//            if(name.toLowerCase() . contains(userInput))
//            {
//                newList.add(name);
//            }
//        }
//        adapter.updateList(newList);
//
//        return true;
//    }
}
