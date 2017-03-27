package dev.xesam.android.fly;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public class SimpleFlyUnit extends FlyUnit {

    private View vTarget;
    private long mDuration;

    public SimpleFlyUnit(View target, long duration) {
        this.vTarget = target;
        this.mDuration = duration;
    }

    @Override
    public View createView(ViewGroup container, Rect from, Rect to) {
        return vTarget;
    }

    @Override
    public Animator createAnim(View target, Paddings containerPaddings, Rect from, Rect to) {
        ValueAnimator animX = ObjectAnimator.ofFloat(
                target,
                "x",
                target.getX() + containerPaddings.left,
                to.left
        );
        ValueAnimator animY = ObjectAnimator.ofFloat(
                target,
                "y",
                target.getY() + containerPaddings.top,
                to.top
        );
        AnimatorSet animationSet = new AnimatorSet().setDuration(mDuration);
        animationSet
                .play(animX)
                .with(animY);
        return animationSet;
    }
}
