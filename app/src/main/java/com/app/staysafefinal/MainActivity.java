package com.app.staysafefinal;

import android.os.Build;
import android.os.Bundle;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.staysafefinal.fragment.ScrollViewFragment;
import com.app.staysafefinal.recycler.RecyclerAdapter;
import com.app.staysafefinal.viewpager.HollyViewPager;
import com.app.staysafefinal.viewpager.HollyViewPagerConfigurator;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int pageCount = 6;
    /*private List<FamilyRecycler> familyRecyclerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FamilyRecyclerAdapter mAdapter;*/

    /*@BindView(R.id.toolbar)
    Toolbar toolbar;*/

    @BindView(R.id.hollyViewPager)
    HollyViewPager hollyViewPager;

    //mrdeveloper
    private FamilyRecycler familytitle;
    private List<FamilyRecycler> familyList = new ArrayList<>();
    private RecyclerAdapter mAdapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(0xFFFFFFFF);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mrdeveloper
        //prepareMovieData();

        hollyViewPager.getViewPager().setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin));
        hollyViewPager.setConfigurator(new HollyViewPagerConfigurator() {
            @Override
            public float getHeightPercentForPage(int page) {
                return ((page+4)%10)/10f;
            }
        });

        hollyViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //if(position%2==0)
                //    return new RecyclerViewFragment();
                //else
                return ScrollViewFragment.newInstance((String) getPageTitle(position));
            }

            @Override
            public int getCount() {
                return pageCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "لو انت " ;
            }
        });

    }

    private void prepareMovieData() {

        FamilyRecycler fatherfamilyRecycler = new FamilyRecycler("لو انت اب", "Animatييييييييييييييion", "1");
        familyList.add(fatherfamilyRecycler);

        FamilyRecycler motherfamilyRecycler = new FamilyRecycler("لو انت ام", "Animبببببببببببببation", "2");
        familyList.add(motherfamilyRecycler);

        FamilyRecycler brotherfamilyRecycler = new FamilyRecycler("لو انت اخ", "Aniبببببببببببببmation", "3");
        familyList.add(brotherfamilyRecycler);

        FamilyRecycler sisterfamilyRecycler = new FamilyRecycler("لو انت اخت", "Animبببببببببation", "4");
        familyList.add(sisterfamilyRecycler);


        //mAdapter.notifyDataSetChanged();
    }




}
