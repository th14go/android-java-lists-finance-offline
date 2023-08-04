package com.tibesoft.listsfinaceoffline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tibesoft.listsfinaceoffline.adapter.ListAdapter;
import com.tibesoft.listsfinaceoffline.databinding.FragmentListBinding;
import com.tibesoft.listsfinaceoffline.viewmodel.ListViewModel;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListViewModel listViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        ListAdapter listAdapter = new ListAdapter();

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        listViewModel.getAllItems().observe(requireActivity(), items -> {
            if (items != null) {
                listAdapter.setItems(items);
            }
        });

        binding.recyclerView.setAdapter(listAdapter);

        binding.buttonAdd.setOnClickListener(v -> {
            new DialogAddListFragment().show(getChildFragmentManager(), "dialog_add_list");
        });

        return binding.getRoot();
    }
}
