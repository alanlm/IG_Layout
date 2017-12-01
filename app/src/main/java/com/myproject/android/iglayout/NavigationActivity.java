package com.myproject.android.iglayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar nav_toolbar;
    View lastViewAdded = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initializeViews();
        initializeSetup();
        selectNavigationItem();
    }

    void initializeViews() {
        bottomNavigationView = findViewById(R.id.navigation);
        nav_toolbar = findViewById(R.id.nav_toolbar);
    }

    void initializeSetup() {
        // disabling shifting mode animation for bottom navigation
        NavigationViewHelper.disableShiftMode(bottomNavigationView);

        selectToolbar(R.layout.layout_toolbar_home);
    }

    void selectNavigationItem() {
        // setting up content frame and toolbar based on navigation item selected
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_nav_home:
                                selectToolbar(R.layout.layout_toolbar_home);
                                break;
                            case R.id.bottom_nav_explore:
                                break;
                            case R.id.bottom_nav_share:
                                break;
                            case R.id.bottom_nav_notifications:
                                selectToolbar(R.layout.layout_toolbar_notifications);
                                break;
                            case R.id.bottom_nav_me:
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    private void selectToolbar(int layoutID) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // if there already exists a layout in toolbar, remove all of it
        if (lastViewAdded != null)
            nav_toolbar.removeAllViews();

        lastViewAdded = inflater.inflate(layoutID, nav_toolbar);
    }
}
