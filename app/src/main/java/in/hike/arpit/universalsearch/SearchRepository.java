package in.hike.arpit.universalsearch;


import java.util.ArrayList;
import java.util.List;

import in.hike.arpit.universalsearch.datasource.IDataSource;
import in.hike.arpit.universalsearch.pojo.Item;
import in.hike.arpit.universalsearch.pojo.SearchItems;
import in.hike.arpit.universalsearch.pojo.SearchResults;

/**
 * Created by arpitratan on 16/11/17.
 */

public class SearchRepository {

    public interface ICallback {
        void onSearchComplete(List<SearchItems> result);
    }

    private List<IDataSource> sources = new ArrayList<>();
    private List<SearchResults> results = new ArrayList<>();
    private ICallback callback;

    public SearchRepository(IDataSource ...sources) {
        for (IDataSource source : sources) {
            this.sources.add(source);
        }
    }

    public boolean search(String searchText, ICallback callback) {
        this.callback = callback;
        results.clear();
        for(IDataSource source : sources) {
            source.search(searchText, getCallback());
        }
        return false;
    }

    public void fetchRecents() {

    }

    public IDataSource.ICallback getCallback() {
        return new IDataSource.ICallback() {
            @Override
            public void onDataFetched(SearchResults result) {
                results.add(result);
                if(results.size() == sources.size()) {
                    callback.onSearchComplete(buildSearchResult());
                }
            }
        };
    }

    private List<SearchItems> buildSearchResult() {
        SearchItems allItems = new SearchItems();
        allItems.setCategory("ALL");

        ArrayList<Item> items = new ArrayList<>();

        allItems.setItems(items);

        List<SearchItems> combinedList = new ArrayList<>();
        for(SearchResults result :  results) {
            combinedList.addAll(result.getResults());
            for(SearchItems item : result.getResults()) {
                if(item.getItems() != null)
                    items.addAll(item.getItems());
            }

        }
        combinedList.add(0, allItems);

        return combinedList;
    }
}
