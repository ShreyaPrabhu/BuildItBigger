package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 * Created by Shreya Prabhu on 10/24/2016.
 */

public class EndpointsAsyncTaskTest extends InstrumentationTestCase implements OnJokeLoaded {
	
	private static String jokeTextResult;
    private static boolean called;
    private CountDownLatch signal;
    final String testEndpoint = "https://builditbigger-147403.appspot.com/_ah/api/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @Override
    public void onJokeLoaded(String jokeText) {
        called = true;
        jokeTextResult = jokeText;
        signal.countDown();
    }

	public void testRetrieveJokeTask() throws InterruptedException, ExecutionException {
        new EndpointsAsyncTask(this).execute(getContext()).get();
        signal.await(30, TimeUnit.SECONDS);
        assertTrue(called);
        assertNotNull(jokeTextResult);
        Boolean stringIsEmpty = jokeTextResult.equals("");
        assertFalse(stringIsEmpty);
    }

}
