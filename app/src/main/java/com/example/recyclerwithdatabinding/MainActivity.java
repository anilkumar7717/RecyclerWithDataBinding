package com.example.recyclerwithdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.recyclerwithdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this,prepareUser());
        binding.recyclerView.setAdapter(adapter);
    }

    private List<User> prepareUser(){
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.name));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));
        int[] imageId = {
                R.drawable.ic_logo,R.drawable.ic_next,R.drawable.slider_image,
                R.drawable.ic_logo,R.drawable.web_hi_res_512,R.drawable.ic_logo,R.drawable.ic_next,R.drawable.slider_image,
                R.drawable.ic_logo,R.drawable.web_hi_res_512,R.drawable.ic_logo,R.drawable.ic_next,R.drawable.slider_image,
                R.drawable.ic_logo,R.drawable.web_hi_res_512,R.drawable.ic_logo,R.drawable.web_hi_res_512};

        List<User> Names = new ArrayList<>();
        int count = 0;
        for(String name : names){

            Names.add(new User(name,emails.get(count),imageId[count]));
            count++;
        }
        return Names;
    }
}
