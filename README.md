# staysafe

[ ![Download](https://api.bintray.com/packages/smarteistbintray/android/androidautoimageslider/images/download.svg) ](https://bintray.com/smarteistbintray/android/androidautoimageslider/_latestVersion)[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android%20Slider-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7693)  [![Apk](https://img.shields.io/badge/download-apk-yellowgreen.svg)](https://raw.githubusercontent.com/android-arsenal/apk31/master/7693/app.apk)

[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


This is an amazing image slider for the Android .
 
You can easily load images with your custom layout, and there are many kinds of amazing animations you can choose.

```groovy
     implementation 'com.github.smarteist:autoimageslider:1.3.7'
```
If you are using appcompat libraries use this one, but please migrate to androidx as soon as you can.
```groovy
     implementation 'com.github.smarteist:autoimageslider:1.3.7-appcompat'
```

### New Feautures
* Minor sliderView API improvements.
* Ability to disable infinite mode.
* bug in issue #130 fixed.

### New Changes
* Auto cycle Bugs fixed.
* Sync state bugs fixed.
* Circular handle completely replaced with infinite wrapper adapter.
because of that the following interface has been replaced with new one.
```CircularSliderHandle.CurrentPageListener```
changed to => `SliderView.OnSliderPageListener`.
* The slider permanently scrolls infinitely, so the following methods have also been deleted.
`sliderView.setCircularHandlerEnabled(boolean enable)`
& its attribute in xml side:
`app:sliderCircularHandlerEnabled="boolean"`
## Demo
![](https://github.com/smarteist/android-image-slider/blob/master/gif/0.gif)
![](https://github.com/smarteist/android-image-slider/blob/master/gif/8.gif)
![](https://github.com/smarteist/android-image-slider/blob/master/gif/4.gif)
![](https://github.com/smarteist/android-image-slider/blob/master/gif/7.gif)

## Integration guide

First put the slider view in your layout xml :

```xml
        <com.smarteist.autoimageslider.SliderView
                    android:id="@+id/imageSlider"
                    android:layout_width="match_parent"
                    android:layout_height="300dp"
                    app:sliderAnimationDuration="600"
                    app:sliderAutoCycleDirection="back_and_forth"
                    app:sliderAutoCycleEnabled="true"
                    app:sliderIndicatorAnimationDuration="600"
                    app:sliderIndicatorGravity="center_horizontal|bottom"
                    app:sliderIndicatorMargin="15dp"
                    app:sliderIndicatorOrientation="horizontal"
                    app:sliderIndicatorPadding="3dp"
                    app:sliderIndicatorRadius="2dp"
                    app:sliderIndicatorSelectedColor="#5A5A5A"
                    app:sliderIndicatorUnselectedColor="#FFF"
                    app:sliderScrollTimeInSec="1"
                    app:sliderStartAutoCycle="true" />
```

Or you can put it inside the cardView to look more beautiful :

```xml
       <androidx.cardview.widget.CardView
               app:cardCornerRadius="6dp"
               android:layout_margin="16dp"
               android:layout_width="match_parent"
               android:layout_height="wrap_content">

               <com.smarteist.autoimageslider.SliderView
                           android:id="@+id/imageSlider"
                           android:layout_width="match_parent"
                           android:layout_height="300dp"
                           app:sliderAnimationDuration="600"
                           app:sliderAutoCycleDirection="back_and_forth"
                           app:sliderAutoCycleEnabled="true"
                           app:sliderIndicatorAnimationDuration="600"
                           app:sliderIndicatorGravity="center_horizontal|bottom"
                           app:sliderIndicatorMargin="15dp"
                           app:sliderIndicatorOrientation="horizontal"
                           app:sliderIndicatorPadding="3dp"
                           app:sliderIndicatorRadius="2dp"
                           app:sliderIndicatorSelectedColor="#5A5A5A"
                           app:sliderIndicatorUnselectedColor="#FFF"
                           app:sliderScrollTimeInSec="1"
                           app:sliderStartAutoCycle="true" />

       </androidx.cardview.widget.CardView>
```

## Next step

The new version requires an slider adapter plus your custom layout for slider items, Although its very similar to RecyclerView & RecyclerAdapter, and it's familiar and easy to implement this adapter... here is an example for adapter implementation :

```java
public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<>();

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        SliderItem sliderItem = mSliderItems.get(position);

        viewHolder.textViewDescription.setText(sliderItem.getDescription());
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
```
## Set the adapter to the Sliderview

After the instantiating of the sliderView (inside the activity or fragment with findViewById|BindView blah blah...), set the adapter to the slider.

```java
    sliderView.setSliderAdapter(new SliderAdapterExample(context));
```

You can call this method if you want to start flipping automatically and you can also set up the slider animation :

```java
    sliderView.startAutoCycle();
    sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
```

## Elaborate more?

Here is a more realistic and more complete example :

```java

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            SliderView sliderView = findViewById(R.id.imageSlider);

            SliderAdapterExample adapter = new SliderAdapterExample(this);

            sliderView.setSliderAdapter(adapter);

            sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
            sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
            sliderView.setIndicatorSelectedColor(Color.WHITE);
            sliderView.setIndicatorUnselectedColor(Color.GRAY);
            sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
            sliderView.startAutoCycle();

        }
```

## Contribute

Suggestions and pull requests are always welcome.
Special Thanks [Roman Danylyk] (https://github.com/romandanylyk) for nice indicator!

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