package vn.luongvo.customlistview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * @author LuongV
 */
public class NotAutoScrollingScrollView extends ScrollView {

    public NotAutoScrollingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        if (focused instanceof ListView)
            return;
        super.requestChildFocus(child, focused);
    }
}
