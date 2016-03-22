package com.crazy.customcomponent;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;


public class TiaoXing extends View{

    // 条形数量
    private int mRectCount = 10;
    // 条形之间的间距
    private int offset = 5;
    // 组件的总宽度
    private float mWidth;
    // 每个条形条目的宽度
    private float mRectWidth;
    // 条形条的最高高度
    private int mRectHeight;
    private Paint mPaint;
    private LinearGradient mLinearGradient;

    public TiaoXing(Context context) {
        this(context, null);
    }

    public TiaoXing(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TiaoXing(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int)(mWidth * 0.8 / mRectCount);

        mLinearGradient = new LinearGradient(0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            float mRandom = (float) Math.random();
            // 随机生成高度，以此来实现条目高度的改变
            float currentHeight = (float)(mRectHeight * mRandom);
            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }
        // 延迟发送，效果更好
        postInvalidateDelayed(300);
    }
}
