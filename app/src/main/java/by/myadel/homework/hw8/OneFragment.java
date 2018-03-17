package by.myadel.homework.hw8;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import by.myadel.homework.R;
import io.reactivex.disposables.Disposable;


public class OneFragment extends Fragment {
    private TextView textView;
    private Disposable subscription;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.hw8_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = getView().findViewById(R.id.hw8_fragment);
    }

    @Override
    public void onResume() {
        super.onResume();
        subscription = ((PublishContract) getActivity()).getObservable()
                .filter(v -> v % 2 == 0)
                .subscribe(value -> textView.setText(String.valueOf(value)));
    }

    @Override
    public void onPause() {
        super.onPause();
        subscription.dispose();
    }
}
