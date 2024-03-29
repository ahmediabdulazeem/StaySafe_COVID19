package com.app.staysafefinal.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.staysafefinal.R;
import com.app.staysafefinal.viewpager.HollyViewPagerBus;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 07/08/15.
 */
public class ScrollViewFragment extends Fragment {

    @BindView(R.id.scrollView)
    ObservableScrollView scrollView;

    @BindView(R.id.title)
    TextView title;

    public static ScrollViewFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString("title",title);
        ScrollViewFragment fragment = new ScrollViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       ButterKnife.bind(this, view);

        title.setText(getArguments().getString("title"));


        HollyViewPagerBus.registerScrollView(getActivity(), scrollView);
    }
}
