package in.hike.arpit.universalsearch;

import android.app.SearchManager;
import android.content.Context;
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

import in.hike.arpit.universalsearch.datasource.RemoteDataSource;
import in.hike.arpit.universalsearch.pojo.SearchItems;

public class SearchActivity extends AppCompatActivity implements ISearchView {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private SearchPresenter mSearchPresenter;


    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = (ViewPager) findViewById(R.id.container);

        mSearchPresenter = new SearchPresenter(this);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setVisibility(View.GONE);
        mTabLayout.setupWithViewPager(mViewPager);
        Log.e("Arpit", "search activiyt");
    }

    @Override
    public void onResultsFetched(List<SearchItems> results) {
        if(mSectionsPagerAdapter == null) {
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), results);
            mViewPager.setAdapter(mSectionsPagerAdapter);
        }
        else {
            mSectionsPagerAdapter.addItems(results);
        }
        mViewPager.setVisibility(View.VISIBLE);
        mTabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default


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
                    mSearchPresenter.search(newText);
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<SearchItems> items = new ArrayList<>();
        private SparseArray<FeedFragment> fragmentReference = new SparseArray<>();


        public SectionsPagerAdapter(FragmentManager fm, List<SearchItems> results) {
            super(fm);
            items = results;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            FeedFragment fragment = FeedFragment.newInstance(items.get(position).getItems());
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

}
