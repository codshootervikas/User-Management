package com.example.usermanagement.restService;

import android.app.Application;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RetrofitClient {
//
//    private static final String BASE_URL = "http://192.168.29.175/UserApi/";
//    private static RetrofitClient retrofitClient;
//    private static Retrofit retrofit;
//
//    // Private constructor to prevent instantiation
//    private RetrofitClient() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    // Synchronized method to ensure thread safety
//    public static synchronized RetrofitClient getInstance() {
//        if (retrofitClient == null) {
//            retrofitClient = new RetrofitClient();
//        }
//        return retrofitClient;
//    }
//
//    // Method to get the API interface
//    public Api getApi() {
//        return retrofit.create(Api.class);
//    }
//}





public class RetrofitClient {
    private static final String BASE_URL = "http://192.168.29.175/UserApi/";
    public static RetrofitClient mInstance;
    public Retrofit retrofit;

    private RetrofitClient(Application application) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        chain -> {
                            Request original = chain.request();
                            Request.Builder requestBuilder = original.newBuilder()
                                    .addHeader("Access-Control-Allow-Origin", "*")
                                    .addHeader("Access-Control-Allow-Methods", "GET,POST,PUT, OPTIONS")
                                    .method(original.method(), original.body());
                            Request request = requestBuilder.build();
                            Response response = chain.proceed(request);
//                            if(response.code()==401){
//                                Intent intent = new Intent(application.getApplicationContext(), MainActivity.class);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                application.getApplicationContext().startActivity(in);
//                            }
                            return response;
                        }
                )  .addInterceptor(new ChuckerInterceptor(application))

                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;

                    }
                })
                .build();


        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .client(okHttpClient)
                .build();

    }



    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new RetrofitClient(application);
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}

