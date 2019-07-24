package com.example123.myapplication;

/*
 *Created by Adithya T Raj on 24-07-2019
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomViews extends View {

    Paint mPaint;
    Rect mRect;
    int mSquareColor;
    int mPadding = 0;

    public MyCustomViews(Context context) {
        super(context);
        init(null);
    }

    public MyCustomViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyCustomViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MyCustomViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();

        if(set == null){
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.MyCustomViews);
        mSquareColor = ta.getColor(R.styleable.MyCustomViews_square_color, Color.GREEN);
        mPaint.setColor(mSquareColor);
        ta.recycle();

    }

    public void swapColor(){

        mPaint.setColor(mPaint.getColor()==mSquareColor?Color.RED:mSquareColor);
        postInvalidate();

    }

    public void customPaddingUp(int padding){

        mPadding = mPadding + padding;
        postInvalidate();

    }

    public void customPaddingDown(int padding){

        mPadding = mPadding -  padding;
        postInvalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRect.left = 0 + mPadding;
        mRect.right = getWidth() - mPadding;
        mRect.top = 0 + mPadding;
        mRect.bottom = getHeight() - mPadding;

        canvas.drawRect(mRect, mPaint);
    }
}
