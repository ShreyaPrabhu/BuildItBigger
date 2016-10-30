package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shreyaprabhu.jokeandroidlibrary.jokeandroidlibraryactivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.OnJokeLoaded;
import com.udacity.gradle.builditbigger.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeLoaded {


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        MobileAds.initialize(getContext(), "ca-app-pub-6192687867828837~3864166706");

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("81D2DFB8D89E8272DBCD85405F609EA7")
                .build();

        mAdView.loadAd(adRequest);
        return root;
    }

   public void tellJoke() {
            new EndpointsAsyncTask(this).execute(getContext());
    }

    @Override
    public void onJokeLoaded(String jokeText) {
        //Toast.makeText(this,jokeText,Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getContext(), jokeandroidlibraryactivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("Joke",jokeText);
        startActivity(intent);
    }
}
