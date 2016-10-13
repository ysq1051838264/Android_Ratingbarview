package com.ysq.android_ratingbarview;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    int oneScore = 0;
    int twoScore = 0;
    int threeScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBarView ratingBarView = (RatingBarView) findViewById(R.id.starView);
        ratingBarView.setmClickable(true);
        RatingBarView ratingBarView2 = (RatingBarView) findViewById(R.id.starTwoView);
        ratingBarView2.setmClickable(true);
        RatingBarView ratingBarView3 = (RatingBarView) findViewById(R.id.starThreeView);
        ratingBarView3.setmClickable(true);

        ExpertStarView starView = (ExpertStarView) findViewById(R.id.expertStarView);

        //you can set up view here or in XML
        ratingBarView.setStarCount(5);
        ratingBarView.setStarEmptyDrawable(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.ic_star_empty)));
        ratingBarView.setStarFillDrawable(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.ic_star_fill)));
        ratingBarView.setStarImageSize(40);

        //bind some data
        ratingBarView.setBindObject(1);
        ratingBarView.setOnRatingListener(new RatingBarView.OnRatingListener() {
            @Override
            public void onRating(Object bindObject, int RatingScore) {
                oneScore = RatingScore;
                Toast.makeText(MainActivity.this, "bindObject : " + RatingScore, Toast.LENGTH_SHORT).show();
            }
        });
        ratingBarView2.setBindObject(2);
        ratingBarView2.setOnRatingListener(new RatingBarView.OnRatingListener() {
            @Override
            public void onRating(Object bindObject, int RatingScore) {
                twoScore = RatingScore;
                Toast.makeText(MainActivity.this, "bindObject : " + RatingScore, Toast.LENGTH_SHORT).show();
            }
        });
        ratingBarView3.setBindObject(3);
        ratingBarView3.setOnRatingListener(new RatingBarView.OnRatingListener() {
            @Override
            public void onRating(Object bindObject, int RatingScore) {
                threeScore = RatingScore;
                Toast.makeText(MainActivity.this, "bindObject : " + RatingScore, Toast.LENGTH_SHORT).show();
            }
        });


        starView.setScore((oneScore + twoScore + threeScore) / 3);

    }


}
