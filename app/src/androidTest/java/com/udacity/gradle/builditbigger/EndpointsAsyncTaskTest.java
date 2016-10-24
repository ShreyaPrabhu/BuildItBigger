package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by Shreya Prabhu on 10/24/2016.
 */

public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> {

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    public void testonPostExecute() throws ExecutionException, InterruptedException {
        assertNotNull(new EndpointsAsyncTask().execute(getContext()).get());

    }

}
