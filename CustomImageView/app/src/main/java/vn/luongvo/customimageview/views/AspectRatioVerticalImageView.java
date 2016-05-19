package vn.luongvo.customimageview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author LuongV
 */
public class AspectRatioVerticalImageView extends ImageView {

    public AspectRatioVerticalImageView(Context context) {
        super(context);
    }

    public AspectRatioVerticalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioVerticalImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getDrawable() != null) {
            int height = MeasureSpec.getSize(heightMeasureSpec);
            int width = height * getDrawable().getIntrinsicWidth() / getDrawable().getIntrinsicHeight();
            setMeasuredDimension(width, height);
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
