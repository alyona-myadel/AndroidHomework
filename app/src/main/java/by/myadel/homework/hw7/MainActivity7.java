package by.myadel.homework.hw7;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import by.myadel.homework.R;
import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity7 extends AppCompatActivity implements PublishContract {
    private boolean isOneVisible = true;
    private ReplaySubject<String> replaySubject = ReplaySubject.create();
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw7_main_activity);
        findViewById(R.id.fragment_changer).setOnClickListener(v -> changeFragment());
        if (savedInstanceState == null) {
            showFragment(FirstFragment.getInstance());
        }
        sendEvent();
    }

    private void changeFragment() {
        sendEvent();
        if (isOneVisible) {
            showFragment(SecondFragment.getInstance());
            isOneVisible = false;
        } else {
            showFragment(FirstFragment.getInstance());
            isOneVisible = true;
        }
    }

    private void sendEvent() {
        replaySubject.onNext(String.valueOf(counter++));
    }

    private void showFragment(android.support.v4.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

    @Override
    public Observable<String> getReplaySubject() {
        return replaySubject;
    }
}
