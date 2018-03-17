package by.myadel.homework.hw7;


import io.reactivex.Observable;

public interface PublishContract {
    Observable<String> getReplaySubject();

}
