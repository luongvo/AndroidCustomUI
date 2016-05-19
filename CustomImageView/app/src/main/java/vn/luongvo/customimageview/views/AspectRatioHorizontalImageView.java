package vn.luongvo.customimageview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author LuongV
 */
public class AspectRatioHorizontalImageView extends ImageView {

    public AspectRatioHorizontalImageView(Context context) {
        super(context);
    }

    public AspectRatioHorizontalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioHorizontalImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getDrawable() != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
            setMeasuredDimension(width, height);
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
