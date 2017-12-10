package in.hike.arpit.universalsearch;

import java.util.List;

import in.hike.arpit.universalsearch.pojo.SearchItems;

/**
 * Created by arpitratan on 11/12/17.
 */

interface ISearchView {
    void onResultsFetched(List<SearchItems> results);
}
