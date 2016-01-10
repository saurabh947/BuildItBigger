package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.saurabh.androidjokes.JokeDetailActivity;

public class MainActivity extends AppCompatActivity implements JokesTask.JokeCallback {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mProgressDialog = ProgressDialog.show(this, getString(R.string.loading_header),
                getString(R.string.loading_message), true);
        JokesTask jokesTask = new JokesTask(this);
        jokesTask.execute();
    }

    @Override
    public void onJokeRetrieved(String joke) {
        mProgressDialog.dismiss();
        Intent intent = new Intent(this, JokeDetailActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}
