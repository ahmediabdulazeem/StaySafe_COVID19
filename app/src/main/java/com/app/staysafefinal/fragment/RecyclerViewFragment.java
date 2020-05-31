package com.app.staysafefinal.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.staysafefinal.R;
import com.app.staysafefinal.recycler.RecyclerAdapter;
import com.app.staysafefinal.viewpager.HollyViewPagerBus;

import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 07/08/15.
 */
public class RecyclerViewFragment extends Fragment {

    //@Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter());


        HollyViewPagerBus.registerRecyclerView(getActivity(), recyclerView);
    }
}
