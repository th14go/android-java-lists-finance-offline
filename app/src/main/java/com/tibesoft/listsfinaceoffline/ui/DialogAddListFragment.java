package com.tibesoft.listsfinaceoffline.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.tibesoft.listsfinaceoffline.data.model.Item;
import com.tibesoft.listsfinaceoffline.databinding.FragmentDialogAddListBinding;
import com.tibesoft.listsfinaceoffline.viewmodel.ListViewModel;

public class DialogAddListFragment extends DialogFragment {

    private FragmentDialogAddListBinding binding;
    private ListViewModel listViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDialogAddListBinding.inflate(inflater, container, false);

        if(getDialog() != null && getDialog().getWindow() != null){
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        binding.buttonAdd.setOnClickListener(v -> {
            String item = binding.editAdd.getText().toString();
            listViewModel.insert(new Item(item));
            dismiss();
        });

        return binding.getRoot();
    }
}
