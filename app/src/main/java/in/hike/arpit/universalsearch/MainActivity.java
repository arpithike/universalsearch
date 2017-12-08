package in.hike.arpit.universalsearch;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.hike.arpit.universalsearch.datasource.ChatDataSource;
import in.hike.arpit.universalsearch.datasource.RemoteDataSource;
import in.hike.arpit.universalsearch.pojo.SearchItems;


public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private DiscoveryFragment mFragment;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private SearchRepository searchRepository = new SearchRepository(new RemoteDataSource()); //new ChatDataSource()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mViewPager = (ViewPager) findViewById(R.id.container);


        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setVisibility(View.GONE);
        mTabLayout.setupWithViewPager(mViewPager);

        if (savedInstanceState == null) {
            mFragment = new DiscoveryFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragment_layout, mFragment).commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                } else {
                    //Toast.makeText(MainActivity.this, "Search string : "+newText, Toast.LENGTH_LONG).show();
                    searchRepository.search(newText, new SearchRepository.ICallback() {
                        @Override
                        public void onSearchComplete(List<SearchItems> results) {
                            if(mSectionsPagerAdapter == null) {
                                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), results);
                                mViewPager.setAdapter(mSectionsPagerAdapter);
                            }
                            else {
                                mSectionsPagerAdapter.addItems(results);
                            }
                            mViewPager.setVisibility(View.VISIBLE);
                            mTabLayout.setVisibility(View.VISIBLE);
                            // Set up the ViewPager with the sections adapter.
                        }
                    });
                }
                return true;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                //mSectionsPagerAdapter.clear();
                //mSectionsPagerAdapter.notifyDataSetChanged();
                mViewPager.setVisibility(View.GONE);
                mTabLayout.setVisibility(View.GONE);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<SearchItems> items = new ArrayList<>();
        private SparseArray<SearchFragment> fragmentReference = new SparseArray<>();


        public SectionsPagerAdapter(FragmentManager fm, List<SearchItems> results) {
            super(fm);
            items = results;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            SearchFragment fragment = SearchFragment.newInstance(items.get(position).getItems());
            fragmentReference.put(position, fragment);
            return fragment;
        }

        public void addItems(List<SearchItems> items) {
            for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getItems() != null) {
                    if(fragmentReference.get(i) != null) {
                        fragmentReference.get(i).addData(items.get(i).getItems());
                    }
                    else {
                        Log.e("Arpit", "why is this null??");
                    }
                }
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return items.size();
        }

        public void clear(){
            items.clear();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return items.get(position).getCategory();
        }
    }

    @Override
    public void onBackPressed() {
        if(((DiscoveryFragment)mFragment).onBackPress()) {
            super.onBackPressed();
        }
    }

}
