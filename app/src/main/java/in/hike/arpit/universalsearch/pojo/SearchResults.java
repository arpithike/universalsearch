package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by arpitratan on 16/11/17.
 */

public class SearchResults {

    @SerializedName("results")
    @Expose
    private List<SearchItems> results = null;
    @SerializedName("has_more")
    @Expose
    private boolean hasMore;
    @SerializedName("status")
    @Expose
    private String status;

    public List<SearchItems> getResults() {
        return results;
    }

    public void setResults(List<SearchItems> results) {
        this.results = results;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public SearchResults withHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SearchResults withStatus(String status) {
        this.status = status;
        return this;
    }
}