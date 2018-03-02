package by.myadel.homework.hw6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.concurrent.ExecutionException;

import by.myadel.homework.R;
import by.myadel.homework.hw6.news.data.News;
import by.myadel.homework.hw6.news.data.NewsStorage;
import by.myadel.homework.hw6.news.downloders.http.HttpDownloader;
import by.myadel.homework.hw6.news.parsers.json.JsonParser;


public class MainActivity6 extends AppCompatActivity {
    NewsStorage newsStorage = new NewsStorage();
    private static final String LINK_JSON = "http://kiparo.ru/t/it_news.json";
    UserAdapter userAdapter = new UserAdapter();
    private RecyclerView recyclerView;
    private Button button;
    private EditText editText;
    private String textKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw6_activity_news);
        start();
        print(newsStorage.getNewsList());
        editText = findViewById(R.id.hw6_edit_text);
    }

    private void print(List<News> news) {
        userAdapter.setNewsList(news);
        recyclerView = findViewById(R.id.fragment_changer);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void start() {
        HttpDownloader downloader = new HttpDownloader();
        JsonParser jsonParser = new JsonParser();
        byte[] bytes = new byte[0];
        try {
            bytes = downloader.execute(LINK_JSON).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            newsStorage = jsonParser.execute(bytes).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
