package tech.finaqua.app.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;

import tech.finaqua.app.fragments.MappingFragment;
import tech.finaqua.app.fragments.Camera2BasicFragment;
import tech.finaqua.app.R;
import tech.finaqua.app.fragments.AboutFragment;
import tech.finaqua.app.fragments.ContactFragment;
import tech.finaqua.app.fragments.EducationFragment;
import tech.finaqua.app.fragments.ForecastFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainPager;
    private PagerAdapter mainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            getSupportActionBar().hide();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        mainPager = (ViewPager) findViewById(R.id.main_pager);
        mainPagerAdapter = new MainPagerAdapter(getFragmentManager());
        mainPager.setAdapter(mainPagerAdapter);

        //TODO : Create bottom bar for navigation purposes
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0 : return new AboutFragment();
                case 1 : return new AboutFragment();
                case 2 : return new MappingFragment();
                case 3 : return new ForecastFragment();
                case 4 : return new EducationFragment();
                case 5 : return new AboutFragment();
                case 6 : return new AboutFragment();
                case 7 : return new AboutFragment();
                case 8 : return new AboutFragment();
                case 9 : return new ContactFragment();
                case 10: return new Camera2BasicFragment();
                default: return new AboutFragment();
            }
//                return new AboutFragment();//fragmentAbout;//new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return 11;//NUM_PAGES;
        }
    }
//    private class MainActivityTasks extends AsyncTask {
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//    }
}
