package in.hike.arpit.universalsearch.datasource;

import java.util.ArrayList;
import java.util.List;

import in.hike.arpit.universalsearch.pojo.Item;
import in.hike.arpit.universalsearch.pojo.SearchItems;
import in.hike.arpit.universalsearch.pojo.SearchResults;

/**
 * Created by arpitratan on 16/11/17.
 */

public class ChatDataSource implements IDataSource {

    @Override
    public boolean search(String searchText, ICallback callback) {
        SearchResults results = new SearchResults();
        SearchItems item = new SearchItems();
        item.setCategory("CHATS");

        ArrayList<Item> items = new ArrayList<>();
        Item i = new Item();
        i.setTitle("Local message 1");
        i.setSubTitle("Mode information about this message");
        items.add(i);

        Item i2 = new Item();
        i2.setTitle("Local message 2");
        i2.setSubTitle("Mode information about this message");
        items.add(i2);

        Item i3 = new Item();
        i3.setTitle("Local message 3");
        i3.setSubTitle("Mode information about this message");
        items.add(i3);

        item.setItems(items);


        List<SearchItems> searchItems = new ArrayList<>();
        searchItems.add(item);
        results.setResults(searchItems);
        callback.onDataFetched(results);
        return false;
    }

    @Override
    public void fetchRecents() {

    }


}
