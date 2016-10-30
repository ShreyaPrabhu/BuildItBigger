package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by Shreya Prabhu on 10/24/2016.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> {

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    @Test
    public void testonPostExecute() throws ExecutionException, InterruptedException {
        assertNotNull(new EndpointsAsyncTask().execute(getContext()).get());

    }

}
