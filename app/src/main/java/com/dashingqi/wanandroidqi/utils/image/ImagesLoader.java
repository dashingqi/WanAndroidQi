package com.dashingqi.wanandroidqi.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils.image
 * @ClassName: ImagesLoader
 * @Author: DashingQI
 * @CreateDate: 2019-06-09 17:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-09 17:51
 * @UpdateRemark: 加载图片工具类
 * @Version: 1.0
 */
public class ImagesLoader {

    /**
     * 加载图片方法
     * @param context  上下文
     * @param path 图片路径
     * @param imageView
     */
    public static void loadImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .into(imageView);
    }
}
