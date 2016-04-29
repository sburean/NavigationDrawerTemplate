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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
