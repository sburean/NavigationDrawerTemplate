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

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.BuildConfig;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Define Variables:
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    /**
     * Remember, to activate the 'Hamburger' icon in-place of the home button, we need:
     * 1: Enable the home button via setDisplayShowHomeEnabled(true)
     * 2: Include the toolbar in the ActionBarDrawerToggle constructor
     * 3: Sync the DrawerLayout on post-create via .SyncState()

     * Lastly, handle the configuration change of the drawer within the Activity's -
     * - onConfigurationChange via: actionBarDrawerToggle.onConfigurationChanged(newConfig)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * IMPORTANT: breakup the onCreate code into chunks and place them into methods.
         * Simply call the methods (with informative named) here.
         */

        initToolbar();
        initViews(savedInstanceState);
    }

    private void initToolbar(){
        //Initialize toolbar and assign it to the activity:
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize the "home" button -> to be converted into a "hamburger" icon
        assert getSupportActionBar() != null : getSupportActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initViews(Bundle savedInstanceState){
        //Initialize the navigationView:
        navView = (NavigationView) findViewById(R.id.navView);

        //When restoring state, first check if it's the initial set-up:
        if(savedInstanceState == null){
            //initial setup; populate main content:
        } else {
            //previous state was restored; correctly update main content titles, data, etc..
        }

        //Create a listener for when we select menu items from the NavigationView:
        class NavigationViewMenuItemClickListener implements NavigationView.OnNavigationItemSelectedListener{
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                //Close the drawer:
                drawerLayout.closeDrawers();

                switch(item.getItemId()){

                    //insert cases & handle them here

                    //---------tmp-------------:
                    case R.id.nav_menu_item1:
                        Toast.makeText(MainActivity.this, "Clicked menu item 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_menu_item2:
                        Toast.makeText(MainActivity.this, "Clicked menu item 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_sub_menu_item_1:
                        Toast.makeText(MainActivity.this, "Clicked sub menu item 1", Toast.LENGTH_SHORT).show();
                        break;
                    //---------tmp-------------

                    default:
                        //When we're in the pre-release stage, throw AssertionError if we reach this case. We shouldn't reach this.
                        if(BuildConfig.DEBUG){
                            //This is treated as empty when we're in the release stage.
                            Log.d("nav_menu", "ERROR - Reached default case");
                        }
                        break;
                }
                return true;
            }
        }

        //Add the listener to the NavigationView: (by instantiating the inner-class above, where we defined it)
        navView.setNavigationItemSelectedListener(new NavigationViewMenuItemClickListener());

        //Initialize DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        /**
         * The actionBarDrawerToggle provides the hamburger icon. If we remove it, we will need to
         * provide our own.
         */

        //Initialize an actionBarToggleListener (for when we open / close drawer)
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
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

            //If we aren't using a navView, we need to Override onOptionsItemSelected(MenuItem item) here
            //and handle drawer item clicks. In the activity's onOptionsItemSelected(MenuItem item), we have
            //to then call actionBarDrawerToggle.onOptionsItemSelected(item) to delegate the action over.
        };

        //Set the actionBarToggleListener to the drawerLayout:
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        /**
         * Add a back-stack listener to the supportFragmentManager to correctly update content titles
         * using the back button.
         *
         * NOTE: Will have to tag any created fragments and then get a reference to them here.
         */
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //Synchronize the home button icon: "hamburger" icon when drawer closed; back arrow when it's open
        if(actionBarDrawerToggle != null){
            actionBarDrawerToggle.syncState();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the toolbar menu: (toolbar_menu.xml)
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle toolbar_menu.xml item clicks here:

        //If needed, we delegate item clicks to actionBarDrawerToggle.onOptionsItemSelected(item) here.
        //For more info, see: http://stackoverflow.com/questions/27790242/android-navigation-double-drawer-with-actionbardrawertoggle

        switch (item.getItemId()) {

            //insert cases & handle them here

            //---------tmp-------------:
            case R.id.toolbar_item_1:
                Toast.makeText(MainActivity.this, "Clicked on toolbar_item_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_item_2:
                Toast.makeText(MainActivity.this, "Clicked on toolbar_item_2", Toast.LENGTH_SHORT).show();
                break;
            //---------tmp-------------:

            default:

                //this should hit if we click on the hamburger now:
                Log.d("toolbar_menu:", "ERROR - Reached default switch case");
                if (BuildConfig.DEBUG) {
                    Log.d("toolbar_menu:", "ERROR - Reached default switch case");
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Handle the configuration change of the DrawerLayout:
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Handle saving state here:
    }


}
