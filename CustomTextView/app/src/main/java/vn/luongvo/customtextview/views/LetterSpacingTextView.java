package vn.luongvo.customtextview.views;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author LuongV
 */
public class LetterSpacingTextView extends TextView {
    private final float DEFAULT_LETTER_SPACING = 5f;

    private float mLetterSpacing = DEFAULT_LETTER_SPACING;
    private CharSequence mOriginalText = "";

    public LetterSpacingTextView(Context context) {
        super(context);
    }

    public LetterSpacingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mOriginalText = super.getText().toString().replace("\u00A0", "");
        applyLetterSpacing();
        this.invalidate();
    }

    public LetterSpacingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public float getLetterSpacing() {
        return mLetterSpacing;
    }

    public void setLetterSpacing(float letterSpacing) {
        this.mLetterSpacing = letterSpacing;
        applyLetterSpacing();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        mOriginalText = text;
        applyLetterSpacing();
    }

    @Override
    public CharSequence getText() {
        return mOriginalText;
    }

    private void applyLetterSpacing() {
        if (mOriginalText == null) {
            mOriginalText = "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mOriginalText.length(); i++) {
            builder.append(mOriginalText.charAt(i));
            if (i + 1 < mOriginalText.length()) {
                builder.append("\u00A0");
            }
        }
        SpannableString finalText = new SpannableString(builder.toString());
        if (builder.toString().length() > 1) {
            for (int i = 1; i < builder.toString().length(); i += 2) {
                finalText.setSpan(new ScaleXSpan((mLetterSpacing + 1) / 10), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        super.setText(finalText, BufferType.SPANNABLE);
    }

}
