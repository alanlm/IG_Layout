package com.myproject.android.iglayout;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by Alan on 11/13/2017.
 */

public class NavigationViewHelper {

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view)
    {
        BottomNavigationMenuView bn_menuView = (BottomNavigationMenuView) view.getChildAt(0);

        try
        {
            Field shiftingMode = bn_menuView.getClass().getDeclaredField("mShiftingMode");

            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(bn_menuView, false);
            shiftingMode.setAccessible(false);

            for(int i=0; i < bn_menuView.getChildCount(); i++)
            {
                BottomNavigationItemView nav_item = (BottomNavigationItemView)bn_menuView.getChildAt(i);
                nav_item.setShiftingMode(false);
                nav_item.setChecked(nav_item.getItemData().isChecked());
            }
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
            Log.e("NAVVIEWHELPER", "Can't find shift mode field");
        } catch(IllegalAccessException e) {
            e.printStackTrace();
            Log.e("NAVVIEWHELPER", "Can't change the shift mode's value");
        }
    }
}
