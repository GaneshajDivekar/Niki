package ni.ki.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

import ni.ki.R;


/**
 * Created by Ganesh Divekar.
 */
public class CRadioButton extends AppCompatRadioButton {

    public CRadioButton(Context context) {
        super(context);
        init(null);
    }

    public CRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if (attrs != null) {
            try {
                TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextFont);
                String font = typedArray.getString(R.styleable.CustomTextFont_fontName);
                setTypeface(FontCache.getTypeface(getContext(), font));

                typedArray.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setTypeface(FontCache.getTypeface(getContext()));
        }

    }

}
