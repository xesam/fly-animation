package dev.xesam.androd.fly.demo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import dev.xesam.android.fly.FlyUnit;
import dev.xesam.android.fly.Paddings;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public class CustomFly extends FlyUnit {

    private long mDuration;

    public CustomFly(long duration) {
        this.mDuration = duration;
    }

    @Override
    public View createView(ViewGroup container, Rect from, Rect to) {
        TextView target = new TextView(container.getContext());
        target.setText("duration = " + mDuration);
        return target;
    }

    @Override
    public Animator createAnim(View target, Paddings containerPaddings, Rect from, Rect to) {
        target.setX(from.left);
        target.setY(from.top);
        ValueAnimator animX = ObjectAnimator.ofFloat(
                target,
                "x",
                target.getX(),
                to.left
        );
        ValueAnimator animY = ObjectAnimator.ofFloat(
                target,
                "y",
                target.getY(),
                to.top
        );
        AnimatorSet animationSet = new AnimatorSet().setDuration(mDuration);
        animationSet.setInterpolator(new BounceInterpolator());
        animationSet
                .play(animX)
                .with(animY);
        return animationSet;
    }
}
