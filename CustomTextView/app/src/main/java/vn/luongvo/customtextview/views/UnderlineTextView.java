package vn.luongvo.customtextview.views;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author LuongV
 */
public class UnderlineTextView extends TextView {
    private boolean mIsModifying;

    public UnderlineTextView(Context context) {
        super(context);
        init();
    }

    public UnderlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnderlineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mIsModifying) {
                    return;
                }

                underlineText();
            }
        });

        underlineText();
    }

    private void underlineText() {
        if (mIsModifying) {
            return;
        }
        mIsModifying = true;

        SpannableString content = new SpannableString(getText());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        setText(content);

        mIsModifying = false;
    }
}
