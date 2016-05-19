package vn.luongvo.customtextview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author LuongV
 */
public class DrawableCenterTextView extends TextView {

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawableLeft = drawables[0];
        Drawable drawableRight = drawables[2];
        if (drawableLeft != null || drawableRight != null) {
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int padding = getPaddingLeft() + getPaddingRight();
            int drawableWidth = 0;
            if (drawableLeft != null)
                drawableWidth = drawableLeft.getIntrinsicWidth();
            else {
                drawableWidth = drawableRight.getIntrinsicWidth();
            }
            float bodyWidth = textWidth + drawableWidth + drawablePadding + padding;
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
