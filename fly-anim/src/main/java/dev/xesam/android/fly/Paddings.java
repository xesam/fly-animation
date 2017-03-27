package dev.xesam.android.fly;

import android.view.View;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public class Paddings {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Paddings() {
    }

    public Paddings(View view) {
        left = view.getPaddingLeft();
        top = view.getPaddingTop();
        right = view.getPaddingRight();
        bottom = view.getPaddingBottom();
    }
}
