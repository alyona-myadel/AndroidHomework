package by.myadel.homework.hw6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import by.myadel.homework.R;
import by.myadel.homework.hw6.news.data.News;


public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<News> newsList = new LinkedList<>();

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> news) {
        this.newsList.clear();
        for (News element : news) {
            if (element.isVisible()) {
                this.newsList.add(element);
            }
            notifyDataSetChanged();
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hw6_fragment_news, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder myHolder = (Holder) holder;
        final News news = newsList.get(position);
        myHolder.mNameTextView.setText(news.getDate());
        myHolder.mSurnameTextView.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mNameTextView, mSurnameTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("User Adapter", "Holder");
            mImageView = itemView.findViewById(R.id.action_image);
            mNameTextView = itemView.findViewById(R.id.textView1);
            mSurnameTextView = itemView.findViewById(R.id.textView2);
        }
    }
}
