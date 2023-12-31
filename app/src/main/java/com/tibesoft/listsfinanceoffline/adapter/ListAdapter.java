package com.tibesoft.listsfinanceoffline.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tibesoft.listsfinanceoffline.data.model.Item;
import com.tibesoft.listsfinanceoffline.databinding.ItemListBinding;
import com.tibesoft.listsfinanceoffline.interfaces.ItemClickListener;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Item> items;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemListBinding binding = ItemListBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.binding.textView.setText(currentItem.getItemName());

        holder.binding.textView.setOnClickListener(v -> {
            if (itemClickListener != null){
                itemClickListener.onItemClick(currentItem.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items){
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding binding;
        public ViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
