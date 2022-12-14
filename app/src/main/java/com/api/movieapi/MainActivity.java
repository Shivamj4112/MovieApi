package com.api.movieapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.api.movieapi.Adapter.DataAdapter;
import com.api.movieapi.Api.ApiClient;
import com.api.movieapi.Api.ApiInterfave;
import com.api.movieapi.ModelClass.Example;
import com.api.movieapi.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
//    private int page = 1;
    private final String api_key = "0bdfaeaa2dd6db35f5f268ded9bd298b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        runapi();

    }

    private void runapi() {

        ApiInterfave apiInterfave = ApiClient.getApiClient().create(ApiInterfave.class);

        apiInterfave.getApiInterface(api_key).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Example data = response.body();

                Log.d("hello", "onSuccess: "+data.getResults());

                LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(MainActivity.this);
                DataAdapter adapter = new DataAdapter(MainActivity.this,data.getResults());

                binding.recycle.setLayoutManager(linearLayoutManager);
                binding.recycle.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Log.d("Mirror", "onFailure: "+t.getMessage());

            }
        });

    }
}