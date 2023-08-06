package com.tibesoft.listsfinanceoffline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tibesoft.listsfinanceoffline.adapter.SublistAdapter;
import com.tibesoft.listsfinanceoffline.databinding.FragmentSublistBinding;
import com.tibesoft.listsfinanceoffline.viewmodel.SublistViewModel;

public class SublistFragment extends Fragment {

    private FragmentSublistBinding binding;
    private SublistViewModel sublistViewModel;
    private SublistAdapter sublistAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSublistBinding.inflate(inflater, container, false);

        Bundle b = getArguments();
        int id = 0;
        if(b != null){
            id = b.getInt("id");
            if(id > -1){
                Toast.makeText(requireActivity(), String.valueOf(id), Toast.LENGTH_SHORT).show();
            }
        }

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        sublistViewModel = new ViewModelProvider(requireActivity()).get(SublistViewModel.class);
        sublistAdapter = new SublistAdapter();

        sublistViewModel.getSublistForList(id).observe(requireActivity(), subItems -> {
            if(subItems != null){
                sublistAdapter.setItems(subItems);
                binding.recyclerView.setAdapter(sublistAdapter);
            }
        });

        return binding.getRoot();
    }
}
