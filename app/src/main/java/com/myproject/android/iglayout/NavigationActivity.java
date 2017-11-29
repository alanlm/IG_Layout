package com.myproject.android.iglayout;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewStub;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // disabling shifting mode animation for bottom navigation
        bottomNavigationView = findViewById(R.id.navigation);
        NavigationViewHelper.disableShiftMode(bottomNavigationView);

        selectNavigationItem();
    }

    private void selectNavigationItem() {
        // setting up content frame and toolbar based on navigation item selected
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_nav_home:
                                Log.d("NAVIGATION SELECT", "You clicked Home");
                                break;
                            case R.id.bottom_nav_explore:
                                Log.d("NAVIGATION SELECT", "You clicked Explore");
                                break;
                            case R.id.bottom_nav_share:
                                Log.d("NAVIGATION SELECT", "You clicked Share");
                                break;
                            case R.id.bottom_nav_notifications:
                                Log.d("NAVIGATION SELECT", "You clicked Notifications");
                                break;
                            case R.id.bottom_nav_me:
                                Log.d("NAVIGATION SELECT", "You clicked your profile");
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
