package in.hike.arpit.universalsearch;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;

import in.hike.arpit.universalsearch.Adapters.DiscoveryAdapter;
import in.hike.arpit.universalsearch.network.HTTPRequest;
import in.hike.arpit.universalsearch.pojo.EachListItem;
import in.hike.arpit.universalsearch.pojo.Example;

/**
 * Created by parveshsingla on 07/12/17.
 */

public class DiscoveryFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private DiscoveryAdapter adapter;
    private List<EachListItem> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.discovery_fragment_layout, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter == null) {
            setUpRecView();
        }
    }

    private void setUpRecView() {
        adapter = new DiscoveryAdapter(listener);
        fetchData();
        adapter.setData(items);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        final StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mRecyclerView.addOnScrollListener(scrollListener);
        mRecyclerView.invalidate();
    }

    public void fetchData() {
        HTTPRequest<Example> httpRequest = new HTTPRequest<>(
                "http://staging.im.hike.in/v2/discover",
                Example.class, null,
                createResponseListener(),
                null);
        MyApplication.getRequestQueue().add(httpRequest);
    }

    private Response.Listener<Example> createResponseListener() {
        return new Response.Listener<Example>() {
            @Override
            public void onResponse(Example response) {
                items.addAll(response.getElements().getList());
                adapter.notifyDataSetChanged();
            }
        };
    }

    public void fetchData1() {
        HTTPRequest<Example> httpRequest = new HTTPRequest<>(
                "http://staging.im.hike.in/v2/discover",
                Example.class, null,
                createResponseListener1(),
                null);
        MyApplication.getRequestQueue().add(httpRequest);
    }

    private Response.Listener<Example> createResponseListener1() {
        return new Response.Listener<Example>() {
            @Override
            public void onResponse(Example response) {
                items.addAll(response.getElements().getList());
//                adapter.notifyDataSetChanged();
            }
        };
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            adapter.setMode(1);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.invalidate();
            adapter.notifyDataSetChanged();
        }
    };

    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            fetchData1();
        }
    };

    public boolean onBackPress() {
        if(adapter.getMode() == 1) {
            adapter.setMode(0);
            final StaggeredGridLayoutManager layoutManager =
                    new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);
            adapter.notifyDataSetChanged();
            return false;
        }
        return true;
    }


}
