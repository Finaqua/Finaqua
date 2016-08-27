package tech.finaqua.app.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
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

    private static final String TAG = "MainActivity";
    private ViewPager mainPager;
    private PagerAdapter mainPagerAdapter;
    private TabLayout tabLayout;

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
        mainPagerAdapter = new MainPagerAdapter(getFragmentManager(), MainActivity.this);
        mainPager.setAdapter(mainPagerAdapter);
        mainPager.setCurrentItem(1);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mainPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        private Context context;
        private String tabTitles[] = new String[] { "Map", "Capture", "About", "Forecast" };
        private int[] imageResId = {
                R.drawable.ic_map,
                R.drawable.ic_capture,
                R.drawable.ic_about,
                R.drawable.ic_forecast
        };

        public MainPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0 : return new MappingFragment();
                case 1 : return new Camera2BasicFragment();
                case 2 : return new AboutFragment();
                case 3 : return new ForecastFragment();
//                case 0 : return new AboutFragment();
//                case 1 : return new AboutFragment();
//                case 2 : return new MappingFragment();
//                case 4 : return new EducationFragment();
//                case 5 : return new AboutFragment();
//                case 6 : return new AboutFragment();
//                case 7 : return new AboutFragment();
//                case 8 : return new AboutFragment();
//                case 9 : return new ContactFragment();
//                case 10: return new Camera2BasicFragment();
                default: return new AboutFragment();
            }
//                return new AboutFragment();//fragmentAbout;//new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return 4;//NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sb;
//            return tabTitles[position];
        }
    }
//    private class MainActivityTasks extends AsyncTask {
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//    }
}
