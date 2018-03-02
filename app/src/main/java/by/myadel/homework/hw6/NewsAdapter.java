package by.myadel.homework.hw6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import by.myadel.homework.R;
import by.myadel.homework.hw6.news.data.News;


public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<News> newsList = new LinkedList<>();

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
        myHolder.id.setText(String.valueOf(news.getId()));
        myHolder.title.setText(news.getTitle());
        myHolder.description.setText(news.getDescription());
        myHolder.date.setText(news.getDate());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView id, title, description, date;

        public Holder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.hw6_1_fragment_text_view);
            title = itemView.findViewById(R.id.hw6_2_fragment_text_view);
            description = itemView.findViewById(R.id.hw6_3_fragment_text_view);
            date = itemView.findViewById(R.id.hw6_4_fragment_text_view);
        }
    }
}
