package com.tibesoft.listsfinanceoffline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tibesoft.listsfinanceoffline.R;
import com.tibesoft.listsfinanceoffline.adapter.ListAdapter;
import com.tibesoft.listsfinanceoffline.databinding.FragmentListBinding;
import com.tibesoft.listsfinanceoffline.viewmodel.ListViewModel;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListViewModel listViewModel;
    private ListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        listAdapter = new ListAdapter();

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        listViewModel.getAllItems().observe(requireActivity(), items -> {
            if (items != null) {
                listAdapter.setItems(items);
                binding.recyclerView.setAdapter(listAdapter);
            }
        });

        clicks();

        return binding.getRoot();
    }

    private void clicks() {
        binding.buttonAdd.setOnClickListener(v -> {
            new DialogAddListFragment().show(getChildFragmentManager(), "dialog_add_list");
        });

        listAdapter.setItemClickListener(id -> {
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            loadFragment(new SublistFragment(), "sublist", bundle);
        });
    }

    private void loadFragment(Fragment fragment, String tag, Bundle bundle){
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(
                R.id.frameLayout, fragment, tag
        ).addToBackStack(tag).commit();
    }
}
