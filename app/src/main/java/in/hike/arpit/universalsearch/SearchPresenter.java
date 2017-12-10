package in.hike.arpit.universalsearch;

import java.util.List;

import in.hike.arpit.universalsearch.datasource.RemoteDataSource;
import in.hike.arpit.universalsearch.pojo.SearchItems;

/**
 * Created by arpitratan on 11/12/17.
 */

public class SearchPresenter {

    private SearchRepository mSearchRepository = new SearchRepository(new RemoteDataSource()); //new ChatDataSource()
    private ISearchView mSearchView;

    public SearchPresenter(ISearchView searchView) {
        this.mSearchView = searchView;
    }

    public void search(String searchString) {

        mSearchRepository.search(searchString, new SearchRepository.ICallback() {
            @Override
            public void onSearchComplete(List<SearchItems> result) {
                if(mSearchView != null) {
                    mSearchView.onResultsFetched(result);
                }

            }
        });
    }

}
