package com.crazy.customcomponent;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewTest extends TextView{

    private Paint mPaint1, mPaint2;

    public TextViewTest(Context context) {
        this(context, null);
    }

    public TextViewTest(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                mPaint1);

        canvas.drawRect(
                10,
                10,
                getMeasuredWidth() - 10,
                getMeasuredHeight() - 10,
                mPaint2);
        canvas.save();
  //      canvas.translate(10, 10);

        super.onDraw(canvas);

        canvas.restore();
    }
}
