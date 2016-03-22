package com.crazy.customcomponent;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

public class ShineTextView extends TextView{

    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int mTranslate;

    public ShineTextView(Context context) {
        this(context, null);
    }

    public ShineTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                // 获取当前绘制 TextView 的 Paint 对象
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{Color.BLUE, 0xffffffff, Color.BLUE},
                        null,
                        Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }
    }
}
