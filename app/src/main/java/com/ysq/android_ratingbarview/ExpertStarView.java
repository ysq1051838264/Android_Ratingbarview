package com.ysq.android_ratingbarview;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class ExpertStarView extends View {
    public static final float MAX = 10.0f;
    float score = -1;

    Bitmap starBm;

    public ExpertStarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        starBm = BitmapFactory.decodeResource(getResources(), R.drawable.air_health_expert_stars);
    }

    public void setScore(float score) {
        this.score = score;
        this.postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (score == -1) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        int bmHeight = (int) ((width / starBm.getWidth()) * starBm.getHeight());
        Bitmap scaleBm = Bitmap.createScaledBitmap(starBm, (int) width, bmHeight, true);
        float topPos = (height - scaleBm.getHeight()) / 2;
        float length = score / MAX * width;

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, topPos + 1, width, topPos + scaleBm.getHeight() - 1, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(0, topPos + 1, length, topPos + scaleBm.getHeight() - 1, paint);
        canvas.drawBitmap(scaleBm, 0, topPos, paint);

    }


}
