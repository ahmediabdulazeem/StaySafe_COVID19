package com.app.staysafefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;

import static android.app.PendingIntent.getActivity;

public class ProfilePage extends AppCompatActivity {

    private CardView maskcard, illearthcard, familycard, healthcard, fathercard, mothercard, youthcard,
            sheyouthcard, gmothercard, gfathercard;

    private TextView conferemedCase, getbetterCase, emergyNumber,peopleAtHome,shopeClosing;
    private ImageView phoneImg,logoutImg;
    private FirebaseAuth auth;
    private LinearLayout existLayout;
    public static PubNub pubnub;
    private AdView mAdView;
    private PublisherInterstitialAd mPublisherInterstitialAd;
    private ProgressBar progressBarH1,progressBarH2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        initView();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        auth = FirebaseAuth.getInstance();


        progressBarH1.setVisibility(View.VISIBLE);
        progressBarH2.setVisibility(View.VISIBLE);
        conferemedCase.setVisibility(View.GONE);
        getbetterCase.setVisibility(View.GONE);


        initAdmob();

        // myRef.setValue("Hello, World!");

        initPubnub();
        createChannel();
        initclickListner();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });






        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);

                String conferemedcase = dataSnapshot.child("conferemedCase").getValue(String.class);
                conferemedCase.setText(conferemedcase);
                progressBarH1.setVisibility(View.GONE);
                conferemedCase.setVisibility(View.VISIBLE);

                String getbettercase = dataSnapshot.child("getbetterCase").getValue(String.class);
                getbetterCase.setText(getbettercase);
                progressBarH2.setVisibility(View.GONE);
                getbetterCase.setVisibility(View.VISIBLE);

                String getpeopleAtHome = dataSnapshot.child("peopleathome").getValue(String.class);
                peopleAtHome.setText(getpeopleAtHome);

                String getShopeClosing = dataSnapshot.child("shopeclosing").getValue(String.class);
                shopeClosing.setText(getShopeClosing);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    private void initView() {

        maskcard = findViewById(R.id.mask);
        illearthcard = findViewById(R.id.illearthcard);
        //familycard = findViewById(R.id.familycard);
        healthcard = findViewById(R.id.healthcard);
        fathercard = findViewById(R.id.fathercard);
        mothercard = findViewById(R.id.mothercard);
        youthcard = findViewById(R.id.youthcard);
        sheyouthcard = findViewById(R.id.sheyouthcard);
        //gmothercard = findViewById(R.id.gmothercard);
        gfathercard = findViewById(R.id.gfathercard);
        conferemedCase = findViewById(R.id.confermedCaseNb);
        getbetterCase = findViewById(R.id.getbetterCaseNb);
        phoneImg = findViewById(R.id.phoneImg);
        emergyNumber = findViewById(R.id.emergNumberTv);
        logoutImg = findViewById(R.id.logoutImg);
        existLayout = findViewById(R.id.exsitLayout);
        peopleAtHome =  findViewById(R.id.peopleAtHome);
        shopeClosing = findViewById(R.id.shopeClosing);
        progressBarH1 = findViewById(R.id.progressBarH1);
        progressBarH2 = findViewById(R.id.progressBarH2);
    }

    private void initclickListner() {

        emergyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:105"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(phoneIntent);

            }
        });

        phoneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:105"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(phoneIntent);


            }
        });

        maskcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Mask.class);
                startActivity(intent);

            }
        });

        illearthcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DangArea.class);
                startActivity(intent);

            }
        });

        healthcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),who.class);
                startActivity(intent);

            }
        });

        //<<<<<<<<< family card with index >>>>>>>>>>

        fathercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fatherActivity.class);
                intent.putExtra("fathercard","fathercard");
                startActivity(intent);
            }
        });

        mothercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fatherActivity.class);
                intent.putExtra("mothercard","mothercard");
                startActivity(intent);
            }
        });

        sheyouthcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fatherActivity.class);
                intent.putExtra("sistercard","sistercard");
                startActivity(intent);
            }
        });

        youthcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fatherActivity.class);
                intent.putExtra("brothercard","brothercard");
                startActivity(intent);
            }
        });

        gfathercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fatherActivity.class);
                intent.putExtra("gmfathercard","gmfathercard");
                startActivity(intent);
            }
        });


        existLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfilePage.this, "Signing out...", Toast.LENGTH_SHORT).show();
                auth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


    }

    public void initAdmob() {

        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId("ca-app-pub-6198897372919858/4521011709");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-6198897372919858/2861565235");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.setAdSize(AdSize.INVALID);
        mAdView.loadAd(adRequest);
    }




    @Override
    public void onBackPressed(){

        Toast.makeText(getApplicationContext(),"Back button is disabled",Toast.LENGTH_LONG);
    }

    private void initPubnub() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey("pub-c-18cac8db-15d0-4687-92c9-284f060c90a7");
        pnConfiguration.setSubscribeKey("sub-c-41c5b612-7d12-11ea-87e8-c6dd1f7701c5");
        pnConfiguration.setSecure(true);
        pubnub = new PubNub(pnConfiguration);
    }
    // Creates notification channel.
    private void createChannel() {
        // Notification channel should only be created for devices running Android API level 26+.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel chan1 = new NotificationChannel(
                    "default",
                    "default",
                    NotificationManager.IMPORTANCE_NONE);
            chan1.setLightColor(Color.TRANSPARENT);
            chan1.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            notificationManager.createNotificationChannel(chan1);
        }
    }
}



