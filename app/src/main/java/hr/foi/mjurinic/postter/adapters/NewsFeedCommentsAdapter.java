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
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedCommentsAdapter extends RecyclerView.Adapter<NewsFeedCommentsAdapter.ViewHolder> {

    private ArrayList<Comments> comments;

    public NewsFeedCommentsAdapter(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.commentAuthor.setText('@' + comments.get(position).getAuthor());
        holder.commentContent.setText(comments.get(position).getBody());
        holder.commentTime.setText(comments.get(position).getCreatedAt().toString());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void appendComment(Comments comment) {
        comments.add(comment);
        notifyDataSetChanged();
    }

    public void refresh(ArrayList<Comments> comments) {
        this.comments.clear();
        this.comments.addAll(comments);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.comment_author)
        TextView commentAuthor;

        @Bind(R.id.comment_created_at)
        TextView commentTime;

        @Bind(R.id.comment_body)
        TextView commentContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
