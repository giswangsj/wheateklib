package com.wheatek.wheateklib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wheatek.lib.WheatekAdManager;

/**
 * Created by shiju.wang on 2018/2/6.
 */

public class TestUtil {

    /**
     * 占位图+失败图
     *
     * @param url
     * @param imageView
     * @param placeholder
     */
    private void loadImg(Context context, String url, ImageView imageView, int placeholder, int error) {
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL).skipMemoryCache(false).placeholder(placeholder).error(error))
                .into(imageView);
    }

    private void loadCircleImg(Context context, String url, ImageView imageView, int placeholder) {
        Glide.with(context).load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())
                                .skipMemoryCache(false)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(placeholder)
//                        .error(error)
                )
                .into(imageView);
    }

    private void test() {
        WheatekAdManager.isPrepared();
    }
}
