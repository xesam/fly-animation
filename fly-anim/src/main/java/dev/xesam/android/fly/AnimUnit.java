package dev.xesam.android.fly;

import android.animation.Animator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public abstract class AnimUnit {
    public abstract View getView(ViewGroup container, Rect from, Rect to);

    public abstract Animator getAnim(Paddings containerPaddings, View target, Rect from, Rect to);
}
