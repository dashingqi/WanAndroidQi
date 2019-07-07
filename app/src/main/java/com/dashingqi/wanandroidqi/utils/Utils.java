package com.dashingqi.wanandroidqi.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils
 * @ClassName: Utils
 * @Author: DashingQI
 * @CreateDate: 2019-07-07 16:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-07-07 16:11
 * @UpdateRemark:
 * @Version: 1.0
 * 工具类的集合
 */
public class Utils {


    public static final HashMap<String,Typeface> cache = new HashMap<>();
    /**
     * 字体转换工具类
     * @param mContext  上下文环境
     * @param assetsPath 字体文件地址
     * @return
     */
    public static Typeface getTypeFace(Context mContext,String assetsPath){
        synchronized (cache){
            if (!cache.containsKey(assetsPath)){
                try{
                    Typeface mTypeface = Typeface.createFromAsset(mContext.getAssets(), assetsPath);
                    cache.put(assetsPath,mTypeface);

                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }

            return cache.get(assetsPath);
        }
    }

}
