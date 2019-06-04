package com.dashingqi.wanandroidqi.network.http.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.http.ssl
 * @ClassName: MyX509TrustAllCert
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 18:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 18:54
 * @UpdateRemark: 定义一个信任所有证书的TrustManager
 * @Version: 1.0
 */
public class MyX509TrustAllCert implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }
}
