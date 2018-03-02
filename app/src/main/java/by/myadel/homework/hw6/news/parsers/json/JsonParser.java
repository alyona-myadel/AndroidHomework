package by.myadel.homework.hw6.news.parsers.json;

import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import by.myadel.homework.hw6.news.data.NewsBuilder;
import by.myadel.homework.hw6.news.data.NewsStorage;


public class JsonParser extends AsyncTask<byte[], Integer, NewsStorage> {
    private NewsStorage newsStorage = new NewsStorage();

    @Override
    protected NewsStorage doInBackground(byte[]... bytes) {
        try {
            com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
            Object object = parser.parse(new String(bytes[0]));
            JsonObject jsonObject = (JsonObject) object;
            newsStorage.setLocation(jsonObject.get("location").getAsString());
            newsStorage.setName(jsonObject.get("name").getAsString());
            JsonArray news = jsonObject.getAsJsonArray("news");
            for (JsonElement elementNews : news) {
                JsonObject elementObj = (JsonObject) elementNews;
                NewsBuilder newsBuilder = new NewsBuilder();
                newsBuilder.setID(elementObj.get("id").getAsLong());
                newsBuilder.setDate(elementObj.get("date").getAsString());
                if (elementObj.has("title")) {
                    newsBuilder.setTitle(elementObj.get("title").getAsString());
                }
                newsBuilder.setDescription(elementObj.get("description").getAsString());
                JsonArray keywords = elementObj.get("keywords").getAsJsonArray();
                if (keywords.size() > 0) {
                    for (JsonElement keyword : keywords) {
                        newsBuilder.addKeyword(keyword.getAsString());
                    }
                }
                newsBuilder.setVisible(elementObj.get("visible").getAsBoolean());
                newsStorage.setNewsList(newsBuilder.build());
            }
            return newsStorage;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}


