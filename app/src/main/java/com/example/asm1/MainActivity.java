package com.example.asm1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lvMain;
    List<carModel> listCarModel;
    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMain = findViewById(R.id.listviewMain);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        Call<List<carModel>> call = apiService.getCars();
        call.enqueue(new Callback<List<carModel>>() {
            @Override
            public void onResponse(Call<List<carModel>> call, Response<List<carModel>> response) {
                if (response.isSuccessful()){
                    listCarModel = response.body();
                    carAdapter = new CarAdapter(getApplicationContext(),listCarModel);
                    lvMain.setAdapter(carAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<carModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}