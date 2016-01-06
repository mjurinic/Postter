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
import hr.foi.mjurinic.postter.models.Comments;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedCommentsAdapter extends RecyclerView.Adapter<NewsFeedCommentsAdapter.ViewHolder> {

    private ArrayList<Comments> newsFeedCommentsResponse;

    public NewsFeedCommentsAdapter(ArrayList<Comments> newsFeedCommentsResponse) {
        this.newsFeedCommentsResponse = newsFeedCommentsResponse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.commentAuthor.setText(newsFeedCommentsResponse.get(position).getAuthor());
        holder.commentContent.setText(newsFeedCommentsResponse.get(position).getBody());
        holder.commentTime.setText(newsFeedCommentsResponse.get(position).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return newsFeedCommentsResponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.comment_author)
        TextView commentAuthor;

        @Bind(R.id.comment_time)
        TextView commentTime;

        @Bind(R.id.comment_content)
        TextView commentContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
