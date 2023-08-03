package com.tibesoft.listsfinaceoffline.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tibesoft.listsfinaceoffline.R;
import com.tibesoft.listsfinaceoffline.databinding.ActivityMainBinding;

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