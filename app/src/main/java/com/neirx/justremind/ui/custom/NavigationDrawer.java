package com.neirx.justremind.ui.custom;


import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.neirx.justremind.R;

/**
 * Created by Waide Shery on 13.10.2017.
 */

public class NavigationDrawer {
    private NavigationView navigationView;
    private Activity activity;
    private DrawerLayout drawerLayout;

    public NavigationDrawer(Activity activity, NavigationView navigationView, DrawerLayout drawerLayout) {
        this(activity, navigationView, drawerLayout, null);
    }

    public NavigationDrawer(Activity activity, NavigationView navigationView,
                            DrawerLayout drawerLayout, Toolbar toolbar) {
        this.navigationView = navigationView;
        this.activity = activity;
        this.drawerLayout = drawerLayout;

        inflateSideMenu(activity);
        prepareSideMenu(navigationView);
        prepareDrawerLayout(drawerLayout, toolbar);
    }

    private void inflateSideMenu(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.nav_drawer, navigationView, false);
        navigationView.addView(view);
    }

    private void prepareSideMenu(NavigationView navigationView) {

    }


    private void prepareDrawerLayout(DrawerLayout drawerLayout, Toolbar toolbar) {
        ActionBarDrawerToggle toggle;
        if(toolbar == null){
            toggle = new ActionBarDrawerToggle(
                    activity, drawerLayout, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close) {
                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    NavigationDrawer.this.onDrawerClosed(drawerView);
                }
            };
        }else{
            toggle = new ActionBarDrawerToggle(
                    activity, drawerLayout, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close) {
                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    NavigationDrawer.this.onDrawerClosed(drawerView);
                }
            };
        }

        drawerLayout.addDrawerListener(toggle);
    }

    private void onDrawerClosed(View drawerView) {

    }
}
