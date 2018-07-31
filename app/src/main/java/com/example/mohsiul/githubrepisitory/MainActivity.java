package com.example.mohsiul.githubrepisitory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);


        Retrofit retrofit= new Retrofit.Builder().baseUrl(api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        api api_list=retrofit.create(api.class);
        //Call <List> gitlist;
        Call<List<GitRepo>> call= api_list.userR("RK123012");

        call.enqueue(new Callback<List<GitRepo>>() {
            @Override
            public void onResponse(Call<List<GitRepo>> call, Response<List<GitRepo>> response) {
                List<GitRepo> gitRepoList;
                gitRepoList = response.body();

                //text1.setText(Jokes_API.getJokes());

                String git_list []= new String[gitRepoList.size()];

                for(int i=0;i<gitRepoList.size();i++)
                {
                    git_list[i]=gitRepoList.get(i).getName();
                }

                listView.setAdapter( new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,git_list));

            }

            @Override
            public void onFailure(Call<List<GitRepo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error klfajklfa",Toast.LENGTH_LONG).show();

            }
        });







    }
}
