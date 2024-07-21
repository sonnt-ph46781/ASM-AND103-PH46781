package com.example.asm1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    public String DOMAIN = "http://10.24.4.15:3000";

    @GET("/api/list")
    Call<List<carModel>> getCars();

}
