package in.hike.arpit.universalsearch;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import in.hike.arpit.universalsearch.network.LRUCache;

/**
 * Created by arpitratan on 17/11/17.
 */

public class MyApplication extends Application {

    private static RequestQueue sRequestQueue;
    private static ImageLoader mImageLoader;


    @Override
    public void onCreate() {
        super.onCreate();
        sRequestQueue = Volley.newRequestQueue(this);

    }

    public static RequestQueue getRequestQueue() {
        return sRequestQueue;
    }

    public static ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(sRequestQueue,
                    new LRUCache());
        }
        return mImageLoader;
    }
}
