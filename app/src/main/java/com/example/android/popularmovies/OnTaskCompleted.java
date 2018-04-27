package com.example.android.popularmovies;

/**
 * Created by ARINZE on 2018-03-27.
 * * <p/>
 * Based on http://stackoverflow.com/questions/9963691/android-asynctask-sending-callbacks-to-ui
 */

public interface OnTaskCompleted {
    void onFetchMoviesTaskCompleted(Movie[] movies);
}
