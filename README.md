# staysafe

[ ![Download](https://api.bintray.com/packages/smarteistbintray/android/androidautoimageslider/images/download.svg) ](https://bintray.com/smarteistbintray/android/androidautoimageslider/_latestVersion)[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android%20Slider-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7693)  [![Apk](https://img.shields.io/badge/download-apk-yellowgreen.svg)](https://github.com/ahmediabdulazeem/staysafe/blob/master/app/staysafe.apk)

[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)



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
