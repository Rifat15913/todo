package com.todo.app.main.data.remote.service.main;

import android.annotation.SuppressLint;

import com.todo.app.BuildConfig;
import com.todo.app.main.data.remote.service.ConnectivityInterceptor;
import com.todo.app.utils.helper.Constants;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class ApiServiceHelper {
    public static OkHttpClient.Builder getUnsafeOkHttpClient(String language, String currency) {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);

            builder.addInterceptor(new ConnectivityInterceptor());

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            else loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            builder.addInterceptor(loggingInterceptor);
            builder.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader(
                                Constants.API.Header.Field.LANGUAGE,
                                language
                        )
                        .addHeader(
                                Constants.API.Header.Field.CURRENCY,
                                currency
                        )
                        .build();

                return chain.proceed(request);
            });

            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
