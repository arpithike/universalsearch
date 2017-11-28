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
public class SearchFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_DATA = "data";

    private RecyclerView mRecyclerView;
    private List<Item> data;

    public SearchFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SearchFragment newInstance(ArrayList<Item> data) {
        SearchFragment fragment = new SearchFragment();
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
        data = getArguments().getParcelableArrayList(ARG_DATA);
        mRecyclerView.setAdapter(new SearchAdapter(data));
        return rootView;
    }
}
