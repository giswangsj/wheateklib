package com.wheatek.wheateklib;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by shiju.wang on 2018/2/6.
 */

public class ImageUtil {

    /**
     * 占位图+失败图
     *
     * @param url
     * @param imageView
     */
    public static void loadImg(Context context, String url, ImageView imageView) {
        loadImg(context, url, imageView, 0, 0);
    }

    /**
     * 占位图+失败图
     *
     * @param url
     * @param imageView
     * @param placeholder
     */
    public static void loadImg(Context context, String url, ImageView imageView, int placeholder, int error) {
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL).skipMemoryCache(false).placeholder(placeholder).error(error))
                .into(imageView);
    }

    public static void loadCircleImg(Context context, String url, ImageView imageView, int placeholder) {
        Glide.with(context).load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())
                                .skipMemoryCache(false)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(placeholder)
//                        .error(error)
                )
                .into(imageView);
    }

    /**
     * 清除内存缓存
     */
    @UiThread
    public void clearAllMemoryCaches(Context context) {
        Glide.get(context).clearMemory();
//        if(Looper.myLooper() == Looper.getMainLooper()){
//        }else{
//            new Handler(Looper.getMainLooper()).post(() -> Glide.get(mContext).clearMemory());
//        }
    }
}
