package by.myadel.homework.hw4.task3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;


public class WatchView extends View {
    private int height, width = 0;
    private int padding = 25;
    private int[] numbers = {3, 6, 9, 12};
    private Paint paint;
    private int radius;
    int notchWidth = 3;
    float rectFBottomMin;

    public WatchView(Context context) {
        super(context);
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WatchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initWatch() {
        height = getHeight();
        width = getWidth();
        paint = new Paint();
        radius = Math.min(height, width) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initWatch();
        drawNumeral(canvas);
        drawNumeral(canvas);
        drawNotches(canvas);
        drawHands(canvas);
        invalidate();
    }

    private void drawNotches(Canvas canvas) {
        float rectFLeft = radius - (float) notchWidth / 2;
        float rectFRight = radius + (float) notchWidth / 2;
        float rectFTop = padding * 1.5f;
        rectFBottomMin = radius / 9;
        float rectFBottomMax = radius / 6;
        RectF rectFMin = new RectF(rectFLeft, rectFTop, rectFRight, rectFBottomMin);
        RectF rectFMax = new RectF(rectFLeft, rectFTop, rectFRight, rectFBottomMax);
        for (int i = 1; i < 13; ++i) {
            canvas.rotate(30, radius, radius);
            if (i == 3 || i == 6 || i == 9 || i == 12) {
                canvas.drawRoundRect(rectFMin, 1, 1, paint);
            } else {
                canvas.drawRoundRect(rectFMax, 1, 1, paint);
            }
        }
    }

    private void drawHands(Canvas canvas) {
        Calendar c = Calendar.getInstance();
        float hour = c.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12 ? hour - 12 : hour;
        drawHand(canvas, (hour + c.get(Calendar.MINUTE) / 60) * 5f, true);
        drawHand(canvas, c.get(Calendar.MINUTE), false);
        drawHand(canvas, c.get(Calendar.SECOND), false);
    }

    private void drawHand(Canvas canvas, double loc, boolean isHour) {
        double angle = Math.PI * loc / 30 - Math.PI / 2;
        float handRadius = isHour ? radius / 2 : radius / 1.5f;
        canvas.drawLine(width / 2, height / 2,
                (float) (width / 2 + Math.cos(angle) * handRadius),
                (float) (height / 2 + Math.sin(angle) * handRadius),
                paint);
    }

    private void drawNumeral(Canvas canvas) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        Rect rect = new Rect();
        for (int number : numbers) {
            String tmp = String.valueOf(number);
            paint.getTextBounds(tmp, 0, tmp.length(), rect);
            double angle = Math.PI / 6 * (number - 3);
            int x = (int) (width / 2 + Math.cos(angle) * (radius - 2 * padding - rect.height()) - rect.width() / 2);
            int y = (int) (height / 2 + Math.sin(angle) * (radius - 2 * padding - rect.height()) + rect.height() / 2);
            canvas.drawText(tmp, x, y, paint);
        }
    }
}
