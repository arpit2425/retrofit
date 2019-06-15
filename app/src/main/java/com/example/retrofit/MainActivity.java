package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
   ApiInterface apiInterface;
   List<contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.hasFixedSize();
        apiInterface=apicall.getApiClient().create(ApiInterface.class);
        Call<List<contact>> call=apiInterface.getcontacts();
        call.enqueue(new Callback<List<contact>>() {
            @Override
            public void onResponse(Call<List<contact>> call, Response<List<contact>> response) {
                list=response.body();
                recyclerView.setAdapter(new recycleAdaptor(list));
            }

            @Override
            public void onFailure(Call<List<contact>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();

            }
        });
    }
}
