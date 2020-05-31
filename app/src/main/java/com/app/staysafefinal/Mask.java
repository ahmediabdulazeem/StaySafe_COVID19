package com.app.staysafefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.staysafefinal.fragment.ClFragment;
import com.app.staysafefinal.fragment.GloovsFragment;
import com.app.staysafefinal.fragment.MaskFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Mask extends AppCompatActivity {

    private TabLayout masktabs;
    private ViewPager maskpager;
    private ImageButton bkbt;
    private ProfilePage admob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask);

        masktabs = findViewById(R.id.masktablayout);
        maskpager = findViewById(R.id.maskviewpagertab);
        bkbt = findViewById(R.id.bkbt2);
        setupViewPager(maskpager);
        masktabs.setupWithViewPager(maskpager);

       // admob.initAdmob();

        bkbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProfilePage.class);
                startActivity(intent);
            }
        });




    }

    private void setupViewPager(ViewPager viewPager) {

        for(int i=0;i>masktabs.getTabCount();i++){

            Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/shahdrontregular.ttf");

            TextView tv = (TextView)LayoutInflater.from(this).inflate(R.layout.fragment_mask_tab,null);
            tv.setTypeface(custom_font);
            masktabs.getTabAt(i).setCustomView(tv);
            Log.e(String.valueOf((masktabs.getTabCount())),"number of tabs");

        }

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new MaskFragment(), "الكمامه");
        adapter.addFragment(new GloovsFragment(), "الجوانتي");
        adapter.addFragment(new ClFragment(),"الكلور");
        //adapter.addFragment(new ThreeFragment(), "THREE");*/
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }







}
