package com.example.olya.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.support.design.widget.NavigationView;


import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        View header = mNavigationView.getHeaderView(0);
        ImageView imgvw = (ImageView) header.findViewById(R.id.imageViewHeader);
        Picasso.with(imgvw.getContext()).load
                ("https://pp.userapi.com/c636518/v636518871/6bf65/eZHO0BZ9YRU.jpg").into(imgvw);

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        FragmentManager fragmentManager = getFragmentManager();
                        Fragment fragment = null;
                        switch (menuItem.getItemId()) {
                            case (R.id.frag1):
                                fragment = new FragmentOne();
                                break;

                            case (R.id.frag2):
                                fragment = new FragmentTwo();
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment)
                                .commit();
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }
}
