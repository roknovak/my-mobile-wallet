package com.rok.mymobilewallet.common;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.rok.mymobilewallet.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rok on 12. 07. 2017.
 */

public abstract class RecyclerViewAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> items;

    public RecyclerViewAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
