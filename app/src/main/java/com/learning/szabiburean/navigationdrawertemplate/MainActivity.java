/**
 * Written on April-26-2016 by Szabi Burean
 *
 * This application contains a skeleton implementation of a NavigationDrawer View.
 * Drawer menu is populated from a menu xml file. Change as needed.
 * * Important * * Make sure to check for:
 * - NavigationView menu width?
 *      - HeaderView height?
 * - Possible memory leaks due to context: [Activity Context vs. Application Context]
 *      - More info here: http://stackoverflow.com/questions/9122627/should-i-use-getapplicationcontext-or-activity-this-in-a-long-running-asynctask
 */

package com.learning.szabiburean.navigationdrawertemplate;

import android.support.annotation.Nullable;
import android.support.design.*;
import android.support.design.BuildConfig;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Define Variables:
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize toolbar and assign it to the activity:
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize the "home" button -> to be converted into a "hamburger" icon
        assert getSupportActionBar() != null : getSupportActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initialize the navigationView:
        navView = (NavigationView) findViewById(R.id.navView);

        //Set the itemSelectedListener for the NavigationView:
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch(item.getItemId()){

                    //insert cases & handle them here


                    //tmp:
                    case R.id.nav_menu_item1:
                        Toast.makeText(getApplicationContext(), "Clicked menu item 1", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_menu_item2:
                        Toast.makeText(getApplicationContext(), "Clicked menu item 2", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        //When we're in the pre-release stage, throw AssertionError if we reach this case. We shouldn't reach this.
                        if(BuildConfig.DEBUG){
                            //This is treated as empty when we're in the release stage.
                            throw new AssertionError("ERROR - Reached default case - onNavigationItemSelected(...)");
                        }
                }
                return false; //this might have to be replaced - @ end of switch


            }
        });

        //Initialize DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        //Initialize an actionBarToggleListener (for when we open / close drawer)
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
//                toolbar, - Double check what this is for
                R.string.drawer_open,
                R.string.drawer_closed){

            //Below we can set the activity's state when the drawer is open/close - if needed. Otherwise leave the bottom two methods empty.

            //Called when drawer is being opened
            @Override
            public void onDrawerOpened(View drawerView) {

                //We could call invalidateOptionsMenu() to request a system call to onCreateOptionsMenu(Menu), more @ http://developer.android.com/reference/android/app/Activity.html#invalidateOptionsMenu()
                super.onDrawerOpened(drawerView);
            }

            //Called when drawer is being closed
            @Override
            public void onDrawerClosed(View drawerView) {
                //We could call invalidateOptionsMenu() to request a system call to onCreateOptionsMenu(Menu), more @ http://developer.android.com/reference/android/app/Activity.html#invalidateOptionsMenu()
                super.onDrawerClosed(drawerView);
            }
        };

        //Set the actionBarToggleListener to the drawerLayout:
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        //Synchronize the home button icon: "hamburger" icon when drawer closed; back arrow when it's open
        actionBarDrawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the toolbar menu:
        // TODO: Continue here; create toolbar menu with a simple add button and do onOptionsMenuItemSel... and handle drawer click there too.
        // TODO: http://www.android4devs.com/2015/06/navigation-view-material-design-support.html
//        getMenuInflater().inflate(R.id.);
        return super.onCreateOptionsMenu(menu);
    }
}
