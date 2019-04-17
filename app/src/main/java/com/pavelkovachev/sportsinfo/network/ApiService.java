package com.pavelkovachev.sportsinfo.network;

import com.pavelkovachev.sportsinfo.App;
import com.pavelkovachev.sportsinfo.BuildConfig;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
public class ApiService extends BaseService {

    private static final int DEFAULT_TIMEOUT = 60;
    private SportsInfoApi sportsInfoApi;

    @Inject
    ApiService() {

    }

    private OkHttpClient createOkHttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(App.getInstance()))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    SportsInfoApi getSportsInfoApi() {
        Retrofit retrofit = initRetrofit(BuildConfig.BASE_URL, createOkHttp());
        sportsInfoApi = retrofit.create(SportsInfoApi.class);
        return sportsInfoApi;
    }
}