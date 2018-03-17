package by.myadel.homework.hw8;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import by.myadel.homework.R;
import io.reactivex.Observable;

public class MainActivity8 extends AppCompatActivity implements PublishContract {
    private Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw8_main_activity);
        showFragment(OneFragment.getInstance());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.hw8_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public Observable<Long> getObservable() {
        return observable;
    }
}
