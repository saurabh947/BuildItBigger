package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.text.TextUtils;

public class JokesTaskAndroidTest extends AndroidTestCase implements JokesTask.JokeCallback {

    public void testVerifyJokesTaskResponse() {
        try {
            new JokesTask(this).execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onJokeRetrieved(String joke) {
        testVerifyResponse(joke);
    }

    public void testVerifyResponse(String joke) {
        boolean isEmptyResponse = TextUtils.isEmpty(joke);
        assertFalse(isEmptyResponse);
    }
}
