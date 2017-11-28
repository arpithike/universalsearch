package in.hike.arpit.universalsearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import in.hike.arpit.universalsearch.pojo.Item;

/**
 * Created by arpitratan on 17/11/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<Item> dataSet;

    public SearchAdapter(List<Item> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        NetworkImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(position).getTitle());
        textViewVersion.setText(dataSet.get(position).getSubTitle());
        imageView.setDefaultImageResId(R.drawable.ic_placeholder);
        imageView.setImageUrl(dataSet.get(position).getUrl(), MyApplication.getImageLoader());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        NetworkImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = (NetworkImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
