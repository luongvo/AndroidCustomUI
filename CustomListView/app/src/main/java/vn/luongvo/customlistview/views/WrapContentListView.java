package vn.luongvo.customlistview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @author LuongV
 */
public class WrapContentListView extends ListView {
    public WrapContentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
