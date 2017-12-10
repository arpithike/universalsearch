package in.hike.arpit.universalsearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.hike.arpit.universalsearch.pojo.Item;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_DATA = "data";

    private RecyclerView mRecyclerView;
    private List<Item> data = new ArrayList<>();

    public FeedFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FeedFragment newInstance(ArrayList<Item> data) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //mRecyclerView.setHasFixedSize(true);
        ArrayList<Item> temp = getArguments().getParcelableArrayList(ARG_DATA);
        if(temp != null)
            data = temp;
        mRecyclerView.setAdapter(new SearchAdapter(data));
        return rootView;
    }

    public void addData(List<Item> items) {
        data.clear();
        data.addAll(items);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
