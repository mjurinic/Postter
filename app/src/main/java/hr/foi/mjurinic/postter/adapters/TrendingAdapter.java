package hr.foi.mjurinic.postter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.models.Trending;

/**
 * Created by mjurinic on 12.01.16..
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    private ArrayList<Trending> trends;

    public TrendingAdapter(ArrayList<Trending> trends) {
        this.trends = trends;
    }

    @Override
    public TrendingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrendingAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TrendingAdapter.ViewHolder holder, int position) {
        holder.tag.setText(trends.get(position).getTag());
        holder.count.setText(Integer.toString(trends.get(position).getCount()));
    }

    @Override
    public int getItemCount() {
        return trends.size();
    }

    public void refresh(ArrayList<Trending> trends) {
        this.trends.clear();
        this.trends.addAll(trends);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.trending_tag)
        TextView tag;

        @Bind(R.id.trending_count)
        TextView count;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
