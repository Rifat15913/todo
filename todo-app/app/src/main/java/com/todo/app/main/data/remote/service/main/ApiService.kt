package com.todo.app.main.data.remote.service.main

import com.google.gson.GsonBuilder
import com.todo.app.BuildConfig
import com.todo.app.main.data.remote.response.*
import com.todo.app.main.data.remote.service.ConnectivityInterceptor
import com.todo.app.utils.helper.Constants
import com.todo.app.utils.helper.LanguageUtils
import com.todo.app.utils.helper.SharedPrefUtils.readString
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * This is the API service interface of the project. This interface contains all the basic methods
 * needed for remote purposes.
 * @author Mohd. Asfaq-E-Azam Rifat
 */
interface ApiService {

    companion object {
        private val gson = GsonBuilder().setLenient().create()

        private val customClient = OkHttpClient.Builder()
            .addInterceptor(ConnectivityInterceptor())
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.HEADERS
                        else HttpLoggingInterceptor.Level.NONE
                }
            )
            .addInterceptor {
                val request: Request = it.request().newBuilder()
                    .addHeader(
                        Constants.API.Header.Field.LANGUAGE,
                        LanguageUtils.getLanguage()
                    )
                    .addHeader(
                        Constants.API.Header.Field.CURRENCY,
                        readString(Constants.PreferenceKeys.MY_CURRENCY)
                    )
                    .build()

                it.proceed(request)
            }
            .build()

        private val sRetrofitBuilder = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                /*ApiServiceHelper.getUnsafeOkHttpClient(
                    LanguageUtils.getLanguage(),
                    readString(Constants.PreferenceKeys.MY_CURRENCY)
                ).build() */// Unsafe client
                customClient // Safe client
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(
                HttpUrl.Builder()
                    .scheme(Constants.Common.HTTPS)
                    .host(
                        if (BuildConfig.DEBUG) Constants.Common.BASE_URL_DEV
                        else Constants.Common.BASE_URL_DEV
                    )
                    .addPathSegment(Constants.Common.PATH_SEGMENT_API)
                    .addPathSegment(Constants.Common.PATH_SEGMENT_SLASH)
                    .build()
            )
            .build()

        private var sInstance: ApiService? = null

        /**
         * This method returns an instance of the this service
         *
         * @return instance of the this service
         * */
        fun on(): ApiService {
            if (sInstance == null) {
                sInstance = sRetrofitBuilder.create(ApiService::class.java)
            }

            return sInstance!!
        }
    }
}