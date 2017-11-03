package cu.cubaconf;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import cu.cubaconf.adapter.EventAdapter;

public class Schedule extends AppCompatActivity {

    public static cu.cubaconf.model.Schedule schedule;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_TITLE);
        bar.setHomeButtonEnabled(true);

        Gson GSON = new Gson();
        Reader reader;


        try {
            reader = new InputStreamReader(getAssets().open("data/schedule.json"));
            schedule = GSON.fromJson(reader, cu.cubaconf.model.Schedule.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule2, menu);
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
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ListView events;
        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                    case 1: {
                        switch (item.getItemId()) {
                            case R.id.navigation_day1:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom1()));
                                return true;
                            case R.id.navigation_day2:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay2().getRoom1()));
                                return true;
                            case R.id.navigation_day3:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay3().getRoom1()));
                                return true;
                        }
                        break;
                    }
                    case 2: {
                        switch (item.getItemId()) {
                            case R.id.navigation_day1:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom2()));
                                return true;
                            case R.id.navigation_day2:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay2().getRoom2()));
                                return true;
                            case R.id.navigation_day3:
                                events.setAdapter(new EventAdapter(getContext(), schedule.getDay3().getRoom2()));
                                return true;
                        }
                        events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom2()));
                        break;
                    }
                    case 3: {
                        switch (item.getItemId()) {
                            case R.id.navigation_day1:

                                return true;
                            case R.id.navigation_day2:

                                return true;
                            case R.id.navigation_day3:

                                return true;
                        }
                        events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom3()));
                        break;
                    }
                    case 4: {
                        switch (item.getItemId()) {
                            case R.id.navigation_day1:

                                return true;
                            case R.id.navigation_day2:

                                return true;
                            case R.id.navigation_day3:

                                return true;
                        }
                        events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom4()));
                        break;
                    }
                    case 5: {
                        switch (item.getItemId()) {
                            case R.id.navigation_day1:

                                return true;
                            case R.id.navigation_day2:

                                return true;
                            case R.id.navigation_day3:

                                return true;
                        }
                        events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom5()));
                        break;
                    }
                }
                return false;
            }
        };

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

            BottomNavigationView navigation = (BottomNavigationView) rootView.findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            events = rootView.findViewById(R.id.listViewEvents);

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: {
                    events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom1()));
                    break;
                }
                case 2: {
                    events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom2()));
                    break;
                }
                case 3: {
                    events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom3()));
                    break;
                }
                case 4: {
                    events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom4()));
                    break;
                }
                case 5: {
                    events.setAdapter(new EventAdapter(getContext(), schedule.getDay1().getRoom5()));
                    break;
                }
            }


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(R.string.room, position + 1);
        }
    }
}
