package com.example.usermanagement.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.usermanagement.ModelResponse.RegisterResponse;
import com.example.usermanagement.restService.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends AndroidViewModel {

    private final MutableLiveData<RegisterResponse> registerLiveData;
    private Application application;

   public RegisterViewModel(Application application){
        super(application);
        this.application = application;
        registerLiveData = new MutableLiveData<>();
    }


    public MutableLiveData<RegisterResponse> getRegisterLiveData(){
        return registerLiveData;
    }


    public void getRegisterObservable(String username, String email,String password){
        RetrofitClient.getInstance(application).getApi().register(username, email, password).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response != null && response.isSuccessful())
                    registerLiveData.postValue(response.body());
                else
                    registerLiveData.postValue(null);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable throwable) {
                registerLiveData.postValue(null);
            }
        });
    }



}
