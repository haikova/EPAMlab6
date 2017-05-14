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
        View navHeader = mNavigationView.getHeaderView(0);
        ImageView image = (ImageView) navHeader.findViewById(R.id.imageView);
        Picasso.with(MainActivity.this).load
                ("https://image.flaticon.com/icons/png/128/119/119591.png").into(image);

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        FragmentManager fragmentManager = getFragmentManager();
                        switch (id) {
                            case (R.id.frag1):
                                Fragment fragment = new FragmentOne();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.content_frame, fragment)
                                        .commit();
                                break;

                            case (R.id.frag2):
                                Fragment fragment2 = new FragmentTwo();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.content_frame, fragment2)
                                        .commit();
                                break;
                        }
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }
}
