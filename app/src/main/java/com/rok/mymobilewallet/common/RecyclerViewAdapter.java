package com.rok.mymobilewallet.common;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.rok.mymobilewallet.entity.EmptyState;
import com.rok.mymobilewallet.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rok on 12. 07. 2017.
 */

public abstract class RecyclerViewAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    public interface ItemClickListener<T> {
        void onItemClicked(T t);
    }

    public interface DataChangeListener {
        void onDataUpdated(Collection data);
    }

    private List<T> items;
    private ItemClickListener itemClickListener;
    private DataChangeListener dataChangeListener;

    public RecyclerViewAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(Collection<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();

        if (dataChangeListener != null) {
            dataChangeListener.onDataUpdated(items);
        }
    }

    public DataChangeListener getOnDataChangeListener() {
        return dataChangeListener;
    }

    public void setOnDataChangeListener(DataChangeListener dataChangeListener) {
        this.dataChangeListener = dataChangeListener;
    }

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bind(items.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public abstract EmptyState getEmptyState();

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);
}
