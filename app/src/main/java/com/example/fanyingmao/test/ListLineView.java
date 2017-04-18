package com.example.fanyingmao.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fanyingmao on 2017/car_3/car_8.
 */

public class ListLineView extends View {
    private String value;
    private PointF current = null, up = null, down = null;
    private float widthMeasureSpec, heightMeasureSpec;
    private Paint mPainLine, mPainText;
    private int size, textSize;
    private static float temHeight = 0;

    private boolean isMid = false;

    public ListLineView(Context context) {
        super(context);
    }

    public ListLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPainLine = new Paint();
        mPainText = new Paint();
        mPainLine.setColor(Color.parseColor("#008c4a"));
        mPainLine.setStyle(Paint.Style.FILL);//充满
        mPainLine.setStrokeWidth(dip2px(5));
        mPainLine.setAntiAlias(true);
        mPainText.setColor(Color.parseColor("#ffffff"));
        textSize = dip2px(16);
        mPainText.setTextSize(textSize);
        mPainText.setAntiAlias(true);
        size = dip2px(12);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.widthMeasureSpec = MeasureSpec.getSize(widthMeasureSpec);
        this.heightMeasureSpec = MeasureSpec.getSize(heightMeasureSpec);
        temHeight = this.heightMeasureSpec == 0 ? temHeight : this.heightMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if (!isMid) {
            if (current == null)
                return;

            if (up != null) {
                canvas.drawLine(up.x, up.y, current.x, current.y, mPainLine);
            }
            if (down != null) {
                canvas.drawLine(down.x, down.y, current.x, current.y, mPainLine);
            }
            Path path1 = new Path();
            path1.moveTo(current.x - size, current.y - size);
            path1.lineTo(current.x + size, current.y - size);
            path1.lineTo(current.x + size, current.y + size);
            path1.lineTo(current.x - size, current.y + size);
            path1.close();//封闭
            canvas.drawPath(path1, mPainLine);
            canvas.drawText(value, current.x - textSize * value.length() * 0.3f, current.y + textSize * 0.3f, mPainText);
        } else {
            if(up != null && down != null){
                canvas.drawLine(up.x, up.y, down.x, down.y, mPainLine);
            }
        }

    }

    public boolean isMid() {
        return isMid;
    }

    public void setMid(boolean mid) {
        isMid = mid;
    }

    public void setCurrent(float x) {
        this.current = new PointF(x, temHeight / 2);
    }

    public void setUp(float x, int upNum) {
        this.up = new PointF(x, -temHeight / 2 - temHeight * upNum);
    }

    public void setDown(float x, int downNum) {
        this.down = new PointF(x, 3 * temHeight / 2 + temHeight * downNum);
    }

    public void setUp(PointF up) {
        this.up = up;
    }

    public void setDown(PointF down) {
        this.down = down;
    }

    private int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void upUI() {
        postInvalidate();
    }
}
