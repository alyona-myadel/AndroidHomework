package by.myadel.homework.hw6.news.data;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * Класс, содержащий все новости.
 */
public class NewsStorage {
    private String location;
    private String name;
    private LinkedList<News> newsList = new LinkedList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(News newsList) {
        this.newsList.add(newsList);
    }

    @Override
    public String toString() {
        StringBuilder newsStorage = new StringBuilder("File{ \nlocation = '").append(location);
        newsStorage.append("', \nname = '").append(name).append("', \nNews{ ");
        for (News news : newsList) {
            if (news.isVisible()) {
                newsStorage.append(news.toString());
            }
        }
        newsStorage.append("\n}");
        return newsStorage.toString();
    }

    /**
     * Метод, позволяющий сделать все новости видимыми.
     */
    public void makeAllNewsVisible() {
        for (News news : newsList) {
            news.setVisible(true);
        }
    }

    /**
     * Поиск новостей по введенному слову или фразе.
     */
    public void wordSearch(String word) {
        for (News news : newsList) {
            if (checkWordInText(news.getTitle(), word) || checkWordInText(news.getDescription(), word)) {
                news.setVisible(true);
            } else {
                news.setVisible(false);
            }
        }

    }

    private boolean checkWordInText(String text, String word) {
        if (text != null) {
            Pattern p = Pattern.compile(".*" + word + ".*", CASE_INSENSITIVE);
            Matcher m = p.matcher(text);
            return m.matches();
        }
        return false;
    }
}
