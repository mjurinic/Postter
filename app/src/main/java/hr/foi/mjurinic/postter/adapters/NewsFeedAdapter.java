package hr.foi.mjurinic.postter.adapters;

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
import hr.foi.mjurinic.postter.helpers.TimeElapsedHelper;
import hr.foi.mjurinic.postter.listeners.NewsFeedClickListener;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    private ArrayList<NewsFeedResponse> posts;
    private NewsFeedClickListener newsFeedClickListener;

    public NewsFeedAdapter(ArrayList<NewsFeedResponse> posts, NewsFeedClickListener newsFeedClickListener) {
        this.posts = posts;
        this.newsFeedClickListener = newsFeedClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.fullName.setText(posts.get(position).getFullName());
        holder.commentsCount.setText(posts.get(position).getCommentsCount() + " comments");
        holder.nick.setText("@" + posts.get(position).getAuthor());
        holder.createdAt.setText(TimeElapsedHelper.CalculateTime(posts.get(position).getCreatedAt()));
        holder.description.setText(posts.get(position).getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsFeedClickListener.onNewsFeedItemClick(posts.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void refresh(ArrayList<NewsFeedResponse> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        notifyDataSetChanged();
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
