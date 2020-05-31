package com.app.staysafefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.app.staysafefinal.fragment.BrotherscrollFragment;
import com.app.staysafefinal.fragment.FatherscrollFragment;
import com.app.staysafefinal.fragment.GmfatherscrollFragment;
import com.app.staysafefinal.fragment.MotherscrollFragment;
import com.app.staysafefinal.fragment.SisterscrollFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.ArrayList;
import java.util.List;

public class fatherActivity extends AppCompatActivity  {

    private ViewPager familypager;
    private String familyMember ="fathercard";
    private int pagerNumber;
    private ProfilePage admob;
    private AdView mAdView;
    private PublisherInterstitialAd mPublisherInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_father);

        familypager = findViewById(R.id.familypager);

        Intent intent = getIntent();

        String fatherValue = intent.getExtras().getString("fathercard");
        String motherValue = intent.getExtras().getString("mothercard");
        String sisterValue = intent.getExtras().getString("sistercard");
        String broValue = intent.getExtras().getString("brothercard");
        String gmfatherValue = intent.getExtras().getString("gmfathercard");

         initAdmob();

        if ( fatherValue!=null) {

            if (fatherValue.equals("fathercard")) {
                Log.i("yarab", intent.getExtras().getString("fathercard"));
                setupViewPager(familypager);

                familypager.setCurrentItem(0);
            }
        }

        if(motherValue!=null){

            if (motherValue.equals("mothercard")) {
                Log.i("yarab", intent.getExtras().getString("mothercard"));
                setupViewPager(familypager);

                familypager.setCurrentItem(1);

            }
        }

       if(sisterValue!=null){

            if (sisterValue.equals("sistercard")) {
                Log.i("yarab", intent.getExtras().getString("sistercard"));
                setupViewPager(familypager);

                familypager.setCurrentItem(2);

            }
        }

       if(broValue!=null){

            if (broValue.equals("brothercard")) {
                Log.i("yarab", intent.getExtras().getString("brothercard"));
                setupViewPager(familypager);

                familypager.setCurrentItem(3);

            }
        }

       if(gmfatherValue!=null){

            if (gmfatherValue.equals("gmfathercard")) {
                Log.i("yarab", intent.getExtras().getString("gmfathercard"));
                setupViewPager(familypager);

                familypager.setCurrentItem(4);

            }
        }

        //setupViewPager(familypager);

//       Log.i("yarab",intent.getExtras().getString("fathercard"));


    }




    private void setupViewPager(ViewPager viewPager) {

        fatherActivity.ViewPagerAdapter adapter = new fatherActivity.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FatherscrollFragment());
        adapter.addFragment(new MotherscrollFragment());
        adapter.addFragment(new SisterscrollFragment());
        adapter.addFragment(new BrotherscrollFragment());
        adapter.addFragment(new GmfatherscrollFragment());



        viewPager.setAdapter(adapter);


        //viewPager.setOffscreenPageLimit(3);

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

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
           // mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }
    }


    public void initAdmob() {

        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId("ca-app-pub-6198897372919858/4521011709");

        //AdView adView = new AdView(this);
        mAdView = findViewById(R.id.adViewFather);
        //mAdView.setAdSize(AdSize.BANNER);
        //mAdView.setAdUnitId("ca-app-pub-6198897372919858/2861565235");
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.setAdSize(AdSize.INVALID);
        mAdView.loadAd(adRequest);

    }






}
