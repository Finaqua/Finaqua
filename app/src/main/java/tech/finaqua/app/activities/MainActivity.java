package tech.finaqua.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;

import tech.finaqua.app.fragments.MappingFragment;
import tech.finaqua.app.fragments.Camera2BasicFragment;
import tech.finaqua.app.R;
import tech.finaqua.app.TrackActivity;
import tech.finaqua.app.fragments.AboutFragment;
import tech.finaqua.app.fragments.ContactFragment;
import tech.finaqua.app.fragments.EducationFragment;
import tech.finaqua.app.fragments.ForecastFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Camera2BasicFragment fragmentCamera = new Camera2BasicFragment();
    private MappingFragment fragmentMapping = new MappingFragment();
    private ForecastFragment fragmentForecast = new ForecastFragment();
    private EducationFragment fragmentEducation = new EducationFragment();
//    fragmentCommunity
//    fragmentRedList
//    fragmentFishBase
//    fragmentRegulations
    private ContactFragment fragmentContact = new ContactFragment();
    private AboutFragment fragmentAbout = new AboutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                replaceFragment(fragmentCamera);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);//setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TODO : Replace with a Main Fragment.
        if (savedInstanceState == null) {
            replaceFragment(fragmentAbout);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_tracking      : startActivity(new Intent(getApplicationContext(), TrackActivity.class)); break;
            case R.id.nav_map           : replaceFragment(fragmentMapping); break;
            case R.id.nav_forecast      : replaceFragment(fragmentForecast); break;
            case R.id.nav_education     : replaceFragment(fragmentEducation); break;
            case R.id.nav_community     : break;
            case R.id.nav_red_list      : break;
            case R.id.nav_fishbase      : break;
            case R.id.nav_regulations   : break;
            case R.id.nav_contact       : replaceFragment(fragmentContact); break;
            case R.id.nav_about         : replaceFragment(fragmentAbout); break;
            default                     : replaceFragment(fragmentCamera); break;
        }
//        /*if (id == R.id.nav_capture) {
//            // Handle the camera action
//            //Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_profile) {
//
//        } else*/ if (id == R.id.nav_tracking) {
//            startActivity(new Intent(getApplicationContext(), TrackActivity.class));
//        } else if (id == R.id.nav_map)          { replaceFragment(new MappingFragment()); }
//        else if (id == R.id.nav_forecast)       { replaceFragment(new ForecastFragment());}
//        else if (id == R.id.nav_education)      { replaceFragment(new EducationFragment()); }
//        else if (id == R.id.nav_community)      { }
//        else if (id == R.id.nav_red_list)       { }
//        else if (id == R.id.nav_fishbase)       { }
//        else if (id == R.id.nav_regulations)    { }
//        else if (id == R.id.nav_contact)        { replaceFragment(new ContactFragment()); }
//        else if (id == R.id.nav_about)          { replaceFragment(new AboutFragment()); }
//        /*if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//TODO : There is a better way to manage fragments, implement it.
    private void replaceFragment(Fragment fragment){
        if(!fragment.isVisible()) {
            fragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
        }
    }
}

