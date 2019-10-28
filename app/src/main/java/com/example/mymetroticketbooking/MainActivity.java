package com.example.mymetroticketbooking;

import android.os.Bundle;

import com.example.mymetroticketbooking.adapter.MyImageTextAdapter;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.List;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

// dsi > /
public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;  // that metro app basix
    private int []images;
    private List<String> nameList , detailsList;
    MyImageTextAdapter adapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ViewFlipper flipperLayout;
    private int []flippingImage;

    // for advertisement purpose
    private AdView adView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initilization();

        setFlippingLayout();

        addPhotos();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.id_routes:
                          item.setChecked(true);
                          toast("routes");
                          drawerLayout.closeDrawers();break;

                    case R.id.id_journey_planner:
                        item.setChecked(true);
                        toast("Journey Planner");
                        drawerLayout.closeDrawers();break;

                    case R.id.id_nearby_stations:
                        item.setChecked(true);
                        toast("Nearby Stations");
                        drawerLayout.closeDrawers();break;

                   case R.id.id_rate_us:
                    item.setChecked(true);
                    toast("Rate Us");
                       drawerLayout.closeDrawers();break;

                    case R.id.nav_share:
                        item.setChecked(true);
                        toast("Share");
                        drawerLayout.closeDrawers();break;

                    case R.id.nav_send:
                        item.setChecked(true);
                        toast("Send");
                        drawerLayout.closeDrawers();break;


                }
                return true;
            }
        });

        viewBannerAdd();
    }

    private void viewBannerAdd() {
        adView = new AdView(getApplicationContext() ,"YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);
        linearLayout.addView(adView);
        adView.loadAd();

    }

    @Override
    protected void onDestroy() {
        if(adView!=null)
              adView.destroy();

        super.onDestroy();
    }

    private void setFlippingLayout() {

        for (int i = 0; i < flippingImage.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(flippingImage[i]);
            flipperLayout.addView(imageView);
        }
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        flipperLayout.setInAnimation( in );
        flipperLayout.setOutAnimation(out);
        flipperLayout.setFlipInterval(2500);

    }

    private void addPhotos() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void initilization() {

        Toolbar toolbar = findViewById(R.id.id_main_app_bar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.id_navigationView);
        flipperLayout = (ViewFlipper) findViewById(R.id.id_my_flipper_layout);
        linearLayout = (LinearLayout)findViewById(R.id.id_addvertisemen_layout);

        recyclerView = findViewById(R.id.recycle_view);
        layoutManager= new GridLayoutManager(this , 2);
        flippingImage = new int[] { R.drawable.metro1 , R.drawable.metro2 ,R.drawable.metro3 };

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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.id_search_menu:
                toast("search it"); break;

            case R.id.id_share_menu:
                toast("sample share menu"); break;

            case R.id.id_open_navig:
                  drawerLayout.openDrawer(GravityCompat.END);
                break;
        }
        return true;
    }

    private void toast(String msg)
    {
        Toast.makeText(this, "  "+  msg, Toast.LENGTH_SHORT).show();
    }

}
