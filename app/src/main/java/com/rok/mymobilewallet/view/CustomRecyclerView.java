package com.rok.mymobilewallet.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.rok.mymobilewallet.common.RecyclerViewAdapter;
import com.rok.mymobilewallet.databinding.LayoutEmptyBinding;
import com.rok.mymobilewallet.entity.EmptyState;

import java.util.Collection;

/**
 * Created by Rok on 26. 08. 2017.
 */

public class CustomRecyclerView extends RelativeLayout {

    private RecyclerView recyclerView;
    private LayoutEmptyBinding emptyLayoutBinding;

    public CustomRecyclerView(Context context) {
        this(context, null);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setAdapter(@NonNull RecyclerViewAdapter adapter) {
        setEmptyState(adapter.getEmptyState());
        recyclerView.setAdapter(adapter);

        adapter.setOnDataChangeListener(new RecyclerViewAdapter.DataChangeListener() {
            @Override
            public void onDataUpdated(Collection data) {
                updateView(data);
            }
        });
    }

    public void setEmptyState(EmptyState emptyState) {
        emptyLayoutBinding.setEmptyState(emptyState);
    }

    private void init() {
        //add recycler view
        final Context context = getContext();
        recyclerView = new RecyclerView(context);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        addView(recyclerView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //add empty view
        final LayoutInflater inflater = LayoutInflater.from(context);
        emptyLayoutBinding = LayoutEmptyBinding.inflate(inflater);
        addView(emptyLayoutBinding.getRoot(), new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    private void updateView(@NonNull Collection data) {
        if (data.isEmpty()) {
            recyclerView.setVisibility(GONE);
            emptyLayoutBinding.getRoot().setVisibility(VISIBLE);
        } else {
            recyclerView.setVisibility(VISIBLE);
            emptyLayoutBinding.getRoot().setVisibility(GONE);
        }
    }
}