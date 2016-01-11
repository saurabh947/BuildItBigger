package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.saurabh.androidjokes.JokeDetailActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokesTask.JokeCallback {
    private ProgressDialog mProgressDialog;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJoke = (Button) root.findViewById(R.id.button_tell_joke);
        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {
        mProgressDialog = ProgressDialog.show(getActivity(), getString(R.string.loading_header),
                getString(R.string.loading_message), true);
        JokesTask jokesTask = new JokesTask(this);
        jokesTask.execute();
    }

    @Override
    public void onJokeRetrieved(String joke) {
        mProgressDialog.dismiss();
        Intent intent = new Intent(getActivity(), JokeDetailActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}
