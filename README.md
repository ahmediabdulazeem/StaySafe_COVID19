# staysafe

[![Apk](https://img.shields.io/badge/download-apk-yellowgreen.svg)](https://github.com/ahmediabdulazeem/staysafe/blob/master/app/staysafe.apk)




This is an Android App for how to avoid Covid19 infection .
 
You can easily know how you can avoid Covid19, and how to make you'r family safe enough with some advices.


### Feautures
* Minor number of recvired people and daily report of infections numbers.
* How to make ever family member deal with Covid19.
* Advices for every family members.
* How to use mask and glooves in the right way.
* How to use disinfectants with no harm.


## Demo
![](https://github.com/ahmediabdulazeem/staysafe/blob/master/screenshots/Screenshot_20200413-153834.png=250*250)
![](https://github.com/ahmediabdulazeem/staysafe/blob/master/screenshots/Screenshot_20200413-153843.png)
![](https://github.com/ahmediabdulazeem/staysafe/blob/master/screenshots/Screenshot_20200413-153853.png)
![](https://github.com/ahmediabdulazeem/staysafe/blob/master/screenshots/Screenshot_20200413-153923.png)


## Some code guide

First put the slider view in your layout xml :

```xml
        <?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/mainPrimary"
    tools:context=".LoginActivity">

  <ImageView
      android:id="@+id/imageView6"
      android:layout_width="wrap_content"
      android:layout_height="482dp"
      android:paddingTop="20dp"
      app:srcCompat="@drawable/earth" />

  <ScrollView
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:layout_gravity="center">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:orientation="vertical">


      <Space
          android:layout_width="match_parent"
          android:layout_height="108dp" />

      <TextView
          android:id="@+id/logintv"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:fontFamily="@font/shahdrontregular"
          android:gravity="center"
          android:text="تسجيل دخول"
          android:textColor="@android:color/white"
          android:textSize="50dp" />

      <Space
          android:layout_width="match_parent"
          android:layout_height="12dp" />

      <EditText
          android:id="@+id/emailetLG"
          android:layout_width="300dp"
          android:layout_height="50dp"
          android:layout_gravity="center"
          android:background="@drawable/shape"
          android:ems="10"
          android:fontFamily="@font/shahdrontregular"
          android:gravity="center"
          android:hint="البريد الخاص بك"
          android:inputType="textEmailAddress"
          android:textColor="@color/boldTextAppColor"
          android:textColorHint="@color/hintAppColor"
          android:textSize="20dp" />

      <Space
          android:layout_width="match_parent"
          android:layout_height="24dp" />

      <EditText
          android:id="@+id/passwordetLG"
          android:layout_width="300dp"
          android:layout_height="50dp"
          android:layout_gravity="center"
          android:background="@drawable/shape"
          android:ems="10"
          android:fontFamily="@font/shahdrontregular"
          android:gravity="center"
          android:hint="كلمه المرور"
          android:inputType="textPassword"
          android:textColor="@color/boldTextAppColor"
          android:textColorHint="@color/hintAppColor"
          android:textSize="20dp" />

      <Space
          android:layout_width="match_parent"
          android:layout_height="20dp" />

      <FrameLayout
          android:layout_width="wrap_content"
          android:layout_height="wrap_content">

        <Button
            android:id="@+id/loginbt"
            android:layout_width="156dp"
            android:layout_height="50dp"
            android:background="@drawable/shape"
            android:fontFamily="@font/shahdrontregular"
            android:text="تسجيل دخول"
            android:textColor="@color/boldTextAppColor" />

        <ProgressBar
            android:id="@+id/progressBarLogin"
            style="?android:attr/progressBarStyle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center" />

      </FrameLayout>

      <Space
          android:layout_width="match_parent"
          android:layout_height="14dp" />

      <TextView
          android:id="@+id/createaccounttv"
          android:layout_width="match_parent"
          android:layout_height="30dp"
          android:layout_gravity="center|center_horizontal|center_vertical"
          android:fontFamily="@font/shahdrontregular"
          android:gravity="center|center_horizontal|center_vertical"
          android:text="انشاء حساب جديد"
          android:textColor="@android:color/white"
          android:textSize="21dp" />

      <Space
          android:layout_width="match_parent"
          android:layout_height="15dp" />

      <TextView
          android:id="@+id/skiptv"
          android:layout_width="match_parent"
          android:layout_height="30dp"
          android:layout_gravity="center|center_horizontal|center_vertical"
          android:fontFamily="@font/shahdrontregular"
          android:gravity="center|center_horizontal|center_vertical"
          android:text="تخطي"
          android:textColor="@android:color/white"
          android:textSize="21dp" />

    </LinearLayout>
  </ScrollView>

</FrameLayout>
```


```xml
       <?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/mainPrimary"
    tools:context=".splashScreen">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/white"
        android:orientation="vertical"
        tools:layout_editor_absoluteY="38dp">

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="25dp"
            android:background="@color/mainPrimary">

        </FrameLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="169dp"
            android:background="@drawable/tabcover"
            android:orientation="vertical">

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <ImageButton
                    android:id="@+id/bkbt2"
                    android:layout_width="50dp"
                    android:layout_height="50dp"
                    android:layout_marginLeft="25dp"
                    android:layout_marginTop="5dp"
                    android:background="@drawable/shape"
                    android:tint="@color/mainPrimary"
                    app:srcCompat="@drawable/abc_vector_test" />

                <ImageView
                    android:id="@+id/imageView4"
                    android:layout_width="113dp"
                    android:layout_height="99dp"
                    android:layout_gravity="center_horizontal|top"
                    app:srcCompat="@drawable/mask" />
            </FrameLayout>

        </LinearLayout>

        <TextView
            android:id="@+id/allyouneed"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:fontFamily="@font/shahdrontregular"
            android:gravity="center"
            android:text="أدوات الوقايه"
            android:textColor="@color/boldTextAppColor"
            android:textSize="30dp"
            android:textStyle="bold" />

        <fragment
            android:id="@+id/fragment2"
            android:name="com.app.staysafefinal.fragment.MaskTab"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <androidx.viewpager.widget.ViewPager
            android:id="@+id/maskviewpagertab"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />


    </LinearLayout>
</FrameLayout>
```



## Licence

Copyright [2020] [Ahmed ibrahem]

   Licensed under the Apache License, Version 2.0;
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
