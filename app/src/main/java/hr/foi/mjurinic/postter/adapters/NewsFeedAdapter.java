package hr.foi.mjurinic.postter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {


    private ArrayList<NewsFeedResponse> newsFeedResponses;

    public NewsFeedAdapter(ArrayList<NewsFeedResponse> newsFeedResponses) {
        this.newsFeedResponses = newsFeedResponses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fullName.setText(newsFeedResponses.get(position).getFullName());

        holder.commentsCount.setText(newsFeedResponses.get(position).getCommentsCount() + "");

        String nick = "@" + newsFeedResponses.get(position).getAuthor();
        holder.nick.setText(nick);

        holder.createdAt.setText(newsFeedResponses.get(position).getCreatedAt());

        holder.description.setText(newsFeedResponses.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return newsFeedResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.news_feed_icon)
        ImageView newsFeedIcon;

        @Bind(R.id.full_name)
        TextView fullName;

        @Bind(R.id.created_at)
        TextView createdAt;

        @Bind(R.id.nick)
        TextView nick;

        @Bind(R.id.description)
        TextView description;

        @Bind(R.id.comments_count)
        TextView commentsCount;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
