package com.tibesoft.listsfinanceoffline.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tibesoft.listsfinanceoffline.data.model.SubItem;
import com.tibesoft.listsfinanceoffline.databinding.ItemSublistBinding;

import java.util.List;

public class SublistAdapter extends RecyclerView.Adapter<SublistAdapter.ViewHolder> {

    private List<SubItem> items;

    @NonNull
    @Override
    public SublistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSublistBinding binding = ItemSublistBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SublistAdapter.ViewHolder holder, int position) {
        SubItem currentItem = items.get(position);
        holder.binding.textView.setText(currentItem.getSubItem_name());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<SubItem> items){
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSublistBinding binding;
        public ViewHolder(ItemSublistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
