package com.myproject.android.iglayout;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // disabling shifting mode animation for bottom navigation 
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        NavigationViewHelper.disableShiftMode(bottomNavigationView);
    }
}
