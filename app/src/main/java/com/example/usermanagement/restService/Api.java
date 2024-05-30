package com.example.usermanagement.restService;

import android.widget.Button;
import com.example.usermanagement.ModelResponse.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );




//    Call<RegisterResponse> register(Button registerBtn);
}
