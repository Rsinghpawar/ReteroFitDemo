package com.example.reterofitdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.example.reterofitdemo.R;
import com.example.reterofitdemo.adapters.RecyclerAdapter;
import com.example.reterofitdemo.api.JsonPlaceHolderApi;
import com.example.reterofitdemo.models.PostModel;
import com.example.reterofitdemo.models.RecyclerModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    Context context;
    ArrayList<RecyclerModel> recyclerModelArray;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    public MainActivity() {
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<PostModel>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<PostModel> data = response.body();

                recyclerModelArray = new ArrayList<>();

//                System.out.println("*******************************************************************");

                for(PostModel postData : data){

                    RecyclerModel model = new RecyclerModel();


//                    System.out.println(postData.getId());
//                    System.out.println(postData.getUserId());
//                    System.out.println(postData.getTextBody());
//                    System.out.println(postData.getTitle());

                    model.setId(String.valueOf(postData.getId()));
                    model.setUserId(String.valueOf(postData.getUserId()));
                    model.setBody(postData.getTextBody());
                    model.setTitle(postData.getTitle());

                    recyclerModelArray.add(model);
                }

                recyclerAdapter = new RecyclerAdapter(recyclerModelArray);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
