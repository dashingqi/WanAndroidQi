package com.dashingqi.wanandroidqi.network.interceptor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.interceptor
 * @ClassName: LogInterceptor
 * @Author: DashingQI
 * @CreateDate: 2019-06-09 15:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-09 15:41
 * @UpdateRemark:
 * @Version: 1.0
 */
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Buffer requestBuffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(requestBuffer);
        } else {
            Logger.d("response.body() == null");
        }

        //打印url信息
        Log.d("OkHttp", request.url() + (request.body() != null ? "?" + _parseParams(request.body(), requestBuffer) : ""));
        final Response response = chain.proceed(request);

        return response;
    }

    @NonNull
    private static String _parseParams(RequestBody body, Buffer requestBuffer) throws UnsupportedEncodingException {
        if (body.contentType() != null && !body.contentType().toString().contains("multipart")) {
            return URLDecoder.decode(requestBuffer.readUtf8(), "UTF-8");
        }
        return "null";
    }

}
