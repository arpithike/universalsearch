package in.hike.arpit.universalsearch.Adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import in.hike.arpit.universalsearch.MyApplication;
import in.hike.arpit.universalsearch.R;
import in.hike.arpit.universalsearch.pojo.EachListItem;

/**
 * Created by parveshsingla on 07/12/17.
 */

public class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryAdapter.ViewHolder> {

    private List<EachListItem> mainCardList;
    private final int SU = 0;
    private final int WIDGET = 1;
    private final int FULL_SCREEN = 2;
    View.OnClickListener listener;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    int mode = 0;

    public DiscoveryAdapter(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<EachListItem> mainCardList) {
        this.mainCardList = mainCardList;
    }

    @Override
    public int getItemViewType(int position) {
        if(mode == 1) {
            return FULL_SCREEN;
        }
        if(position != 0 && position % 6 == 0) {
            return WIDGET;
        }
        EachListItem item = mainCardList.get(position);
        if(item.getT().equals("su")){
            return SU;
        } else if(item.getT().equals("widget")){
            return WIDGET;
        }

        return 1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        //decide view type here and call oncreateview of that type
        if(type == SU) {
            return onCreateViewHolder1(viewGroup, listener);
        } else if(type == WIDGET) {
            return onCreateViewHolder2(viewGroup, listener);
        } else if(type == FULL_SCREEN) {
            return onCreateViewHolder3(viewGroup);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int positionItem) {
        //call bindViewHolder using position
        EachListItem item = mainCardList.get(positionItem);
        int type = getItemViewType(positionItem);
        if(type == SU) {
            onBindViewHolder1(item, viewHolder);
        } else if(type == WIDGET) {
            onBindViewHolder2(item, viewHolder);
        } else if(type == FULL_SCREEN) {
            onBindViewHolder3(item, viewHolder);
        }
    }

    @Override
    public int getItemCount() {
        return mainCardList.size();
    }

    public ViewHolder onCreateViewHolder1(ViewGroup parent, View.OnClickListener listener) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout1, parent, false);
        ViewHolder viewHolder =  new ViewHolder(v);
        NetworkImageView imageView = (NetworkImageView) v.findViewById(R.id.imageView);
        imageView.setOnClickListener(listener);
        viewHolder.setImageView(imageView);
        return viewHolder;
    }

    public ViewHolder onCreateViewHolder2(ViewGroup parent, View.OnClickListener listener) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout2, parent, false);
        ViewHolder viewHolder =  new ViewHolder(v);
        NetworkImageView imageView = (NetworkImageView) v.findViewById(R.id.imageView);
        imageView.setOnClickListener(listener);
        viewHolder.setImageView(imageView);
        return viewHolder;
    }

    public void onBindViewHolder1(EachListItem item, ViewHolder viewHolder) {
        NetworkImageView imageView = viewHolder.getImageView();
        String url ;
        if(item.getD() == null) {
            url = "http://www.makeathumbnail.com/thumbnails/image598310.jpeg";
        } else {
            url = item.getD().getTnUrl();
        }
        imageView.setDefaultImageResId(R.drawable.loading);
        imageView.setImageUrl(url, MyApplication.getImageLoader());
    }

    public void onBindViewHolder2(EachListItem item, ViewHolder viewHolder) {
        StaggeredGridLayoutManager.LayoutParams layoutParams =
                (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
        layoutParams.setFullSpan(true);
        NetworkImageView imageView = viewHolder.getImageView();
        String url ;
        if(item.getD() == null) {
            url = "http://www.makeathumbnail.com/thumbnails/image598310.jpeg";
        } else {
            url = item.getD().getTnUrl();
        }
        imageView.setDefaultImageResId(R.drawable.loading);
        imageView.setImageUrl(url, MyApplication.getImageLoader());
    }

    public ViewHolder onCreateViewHolder3(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout2, parent, false);
        ViewHolder viewHolder =  new ViewHolder(v);
        NetworkImageView imageView = (NetworkImageView) v.findViewById(R.id.imageView);
        viewHolder.setImageView(imageView);
        return viewHolder;
    }

    public void onBindViewHolder3(EachListItem item, ViewHolder viewHolder) {
        NetworkImageView imageView = viewHolder.getImageView();
        String url ;
        if(item.getD() == null) {
            url = "http://www.makeathumbnail.com/thumbnails/image598310.jpeg";
        } else {
            url = item.getD().getTnUrl();
        }
        imageView.setDefaultImageResId(R.drawable.loading);
        imageView.setImageUrl(url, MyApplication.getImageLoader());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public NetworkImageView getImageView() {
            return imageView;
        }

        public void setImageView(NetworkImageView imageView) {
            this.imageView = imageView;
        }

        public NetworkImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}