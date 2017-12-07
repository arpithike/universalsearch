package in.hike.arpit.universalsearch.datasource;

import com.android.volley.Response;

import in.hike.arpit.universalsearch.MyApplication;
import in.hike.arpit.universalsearch.network.HTTPRequest;
import in.hike.arpit.universalsearch.pojo.SearchResults;

/**
 * Created by arpitratan on 16/11/17.
 */

public class RemoteDataSource implements IDataSource {


    @Override
    public boolean search(String searchText, ICallback callback) {
        if(null == callback) {
            throw new IllegalArgumentException("callback can't be null");
        }
        HTTPRequest<SearchResults> httpRequest = new HTTPRequest<>(
                "http://staging.im.hike.in/v2/search?from=0&query="+searchText,
                SearchResults.class, null,
                createResponseListener(callback),
                null);
        MyApplication.getRequestQueue().add(httpRequest);
        return false;
    }

    @Override
    public void fetchRecents() {

    }

    private Response.Listener<SearchResults> createResponseListener(final ICallback callback) {
        return new Response.Listener<SearchResults>() {
            @Override
            public void onResponse(SearchResults response) {
                callback.onDataFetched(response);
            }
        };
    }
}
