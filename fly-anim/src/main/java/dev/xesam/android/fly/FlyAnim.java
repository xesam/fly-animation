package dev.xesam.android.fly;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by xe on 16-12-16.
 */

@Deprecated
public abstract class FlyAnim {
    protected ViewGroup vContainer;
    protected View vFrom;
    protected View vTo;

    public Rect getRect(ViewGroup container, View target) {
        if (container == target) {
            throw new RuntimeException("container must not equals target");
        }

        Rect rect = new Rect(target.getLeft(), target.getTop(), target.getRight(), target.getBottom());
        ViewParent parent;

        while ((parent = target.getParent()) != null) {
            if (parent instanceof ViewGroup) {
                ViewGroup tmp = (ViewGroup) parent;
                if (parent == container) {
                    return rect;
                }
                rect.left += tmp.getLeft();
                rect.top += tmp.getTop();
                rect.right += tmp.getLeft();
                rect.bottom += tmp.getTop();

                target = tmp;
            } else {
                throw new RuntimeException("container does not contains target");
            }

        }
        throw new RuntimeException("container does not contains target");
    }

    public FlyAnim container(ViewGroup container) {
        vContainer = container;
        return this;
    }

    public FlyAnim from(View from) {
        vFrom = from;
        return this;
    }

    public FlyAnim to(View to) {
        vTo = to;
        return this;
    }

    protected abstract View createFly(Rect from);

    public void start() {
        Rect from = getRect(vContainer, vFrom);
        Rect to = getRect(vContainer, vTo);
        final View view = createFly(from);

        ValueAnimator animX = ObjectAnimator.ofFloat(
                view,
                "x",
                view.getX(),
                to.left
        );
        ValueAnimator animY = ObjectAnimator.ofFloat(
                view,
                "y",
                view.getY(),
                to.top
        );
        vContainer.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                vContainer.removeView(view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                vContainer.removeView(view);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animationSet
                .play(animX)
                .with(animY);
        animationSet.setDuration(3000)
                .start();
    }
}
