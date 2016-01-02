package com.saurabh.androidjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_detail_activity);

        Bundle bundle = getIntent().getExtras();
        String joke = bundle.getString("joke");

        TextView txtJoke = (TextView)findViewById(R.id.text_joke);
        if (!TextUtils.isEmpty(joke)) {
            txtJoke.setText(joke);
        } else {
            Toast.makeText(this, "Error loading the joke!", Toast.LENGTH_LONG).show();
        }
    }
}
