package com.example.usermanagement.ModelResponse;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    String error;
    String messege;

    public RegisterResponse(String error, String messege) {
        this.error = error;
        this.messege = messege;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
