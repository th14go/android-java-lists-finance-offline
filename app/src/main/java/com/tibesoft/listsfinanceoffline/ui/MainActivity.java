package com.tibesoft.listsfinanceoffline.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tibesoft.listsfinanceoffline.R;
import com.tibesoft.listsfinanceoffline.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(
                R.id.frameLayout, new ListFragment(), "list"
        ).commit();
    }
}