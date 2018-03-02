package by.myadel.homework.hw6.news.downloders.http;


import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader extends AsyncTask<String, Integer, byte[]> {
    @Override
    protected byte[] doInBackground(String... urls) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urls[0]).openConnection();
            if (connection.getResponseCode() != 200) {
                throw new HttpErrorException();
            }
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        } catch (IOException | HttpErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
