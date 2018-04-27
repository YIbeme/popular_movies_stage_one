package com.example.android.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by ARINZE on 2018-03-18.
 */

public class ImageAdapter extends BaseAdapter {

    /*private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }*/


    private final Context mContext;
    private final Movie[] mMovies;

    /**
     * Constructor
     *
     * @param context Application context
     * @param movies  Movie array
     */
    public ImageAdapter(Context context, Movie[] movies) {
        mContext = context;
        mMovies = movies;
    }



    @Override
    public int getCount() {
        if (mMovies == null || mMovies.length == 0) {
            return -1;
        }

        return mMovies.length;
    }

    @Override
    public Movie getItem(int position) {
        if (mMovies == null || mMovies.length == 0) {
            return null;
        }

        return mMovies[position];
    }


    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            /*imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);*/

            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)

                //.load(mThumbIds[position]) worked when I used static images reference for example purposes
                .load(mMovies[position].getPosterPath())
                .resize(mContext.getResources().getInteger(R.integer.tmdb_poster_w185_width),
                        mContext.getResources().getInteger(R.integer.tmdb_poster_w185_height))
                .centerCrop()
                .into(imageView);

        //imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    /*// references to our images
    private Integer[] mThumbIds = {
            R.drawable.romance,
            R.drawable.png_trans_1, R.drawable.spacemovie,
            R.drawable.wonderwoman, R.drawable.spacemovie,
            R.drawable.wonderwoman, R.drawable.romance,
            R.drawable.romance, R.drawable.romance,
            R.drawable.png_trans_1, R.drawable.png_trans_1,
            R.drawable.spacemovie, R.drawable.png_trans_1,
            R.drawable.wonderwoman, R.drawable.spacemovie,
            R.drawable.romance, R.drawable.wonderwoman,
            R.drawable.romance
    };*/
}
