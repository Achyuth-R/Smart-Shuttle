package com.vit.gokul.newapp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.Manifest;

public class studentMainView extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    LocationManager locationManager;
    String provider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_view);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(studentMainView.this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //This is to open Main Menu at the beginning of APP
        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentStudentMain()).commit();
        navigationView.setCheckedItem(R.id.nav_home);}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_student_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentStudentMain()).commit();
                break;

            case R.id.nav_student_Payment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentStudentPayment()).commit();
                break;

            case R.id.nav_student_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentStudentProfile()).commit();
                break;

            case R.id.nav_student_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new fragmentStudentReport()).commit();
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
