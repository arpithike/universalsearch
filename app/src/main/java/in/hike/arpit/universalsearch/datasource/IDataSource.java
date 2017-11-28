package in.hike.arpit.universalsearch.datasource;

import in.hike.arpit.universalsearch.pojo.SearchResults;

/**
 * Created by arpitratan on 16/11/17.
 */

public interface IDataSource {

    interface ICallback {
        void onDataFetched(SearchResults result);
    }

    boolean search(String searchText, ICallback callback);

    void fetchRecents();

}
