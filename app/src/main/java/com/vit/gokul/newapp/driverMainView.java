package com.vit.gokul.newapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class driverMainView extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main_view);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(driverMainView.this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //This is to open Main Menu at the beginning of APP
        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentDriverMain()).commit();
        navigationView.setCheckedItem(R.id.nav_home);}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentDriverMain()).commit();
                break;

            case R.id.nav_access:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentDriverAccess()).commit();
                break;

            case R.id.nav_cab:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentDriverCab()).commit();
                break;

            case R.id.nav_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentDriverReport()).commit();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}
