package hr.foi.mjurinic.postter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.helpers.TimeElapsedHelper;
import hr.foi.mjurinic.postter.models.MyPostsResponse;

/**
 * Created by mjurinic on 12.01.16..
 */
public class MyPostsAdapter extends RecyclerView.Adapter<MyPostsAdapter.ViewHolder> {

    private ArrayList<MyPostsResponse> posts;

    public MyPostsAdapter(ArrayList<MyPostsResponse> posts) {
        this.posts = posts;
    }

    @Override
    public MyPostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyPostsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyPostsAdapter.ViewHolder holder, int position) {
        holder.fullName.setText(posts.get(position).getPost().getFullName());
        holder.nick.setText('@' + posts.get(position).getPost().getAuthor());
        holder.body.setText(posts.get(position).getPost().getBody());
        holder.createdAt.setText(TimeElapsedHelper.CalculateTime(posts.get(position).getPost().getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void refresh(ArrayList<MyPostsResponse> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.my_post_item_layout)
        RelativeLayout layout;

        @Bind(R.id.my_post_avatar)
        ImageView avatar;

        @Bind(R.id.my_post_full_name)
        TextView fullName;

        @Bind(R.id.my_post_nick)
        TextView nick;

        @Bind(R.id.my_post_body)
        TextView body;

        @Bind(R.id.my_post_created_at)
        TextView createdAt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
