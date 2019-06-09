package com.dashingqi.wanandroidqi.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils.image
 * @ClassName: BannerImageLoader
 * @Author: DashingQI
 * @CreateDate: 2019-06-09 17:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-09 17:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        ImagesLoader.loadImage(context, (String) path, imageView);
    }
}
