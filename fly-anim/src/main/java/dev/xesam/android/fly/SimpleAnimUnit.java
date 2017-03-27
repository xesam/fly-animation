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

public class SimpleAnimUnit extends AnimUnit {

    private View vTarget;
    private long mDuration;

    public SimpleAnimUnit(View target, long duration) {
        this.vTarget = target;
        this.mDuration = duration;
    }

    @Override
    public View getView(ViewGroup container, Rect from, Rect to) {
        return vTarget;
    }

    @Override
    public Animator getAnim(Paddings containerPaddings, View target, Rect from, Rect to) {
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
        AnimatorSet animationSet = new AnimatorSet();
        animationSet
                .play(animX)
                .with(animY);
        animationSet.setDuration(mDuration);
        return animationSet;
    }
}
