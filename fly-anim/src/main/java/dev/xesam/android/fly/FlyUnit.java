package dev.xesam.android.fly;

import android.animation.Animator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public abstract class FlyUnit {
    public abstract View createView(ViewGroup container, Rect from, Rect to);

    public abstract Animator createAnim(View target, Paddings containerPaddings, Rect from, Rect to);
}
