package dev.xesam.android.fly;

import android.animation.Animator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by xesamguo@gmail.com on 17-3-27.
 */

public class FlyPlayer {

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

    public FlyPlayer container(ViewGroup container) {
        vContainer = container;
        return this;
    }

    public FlyPlayer from(View from) {
        vFrom = from;
        return this;
    }

    public FlyPlayer to(View to) {
        vTo = to;
        return this;
    }

    public void play(AnimUnit animUnit) {
        Rect from = getRect(vContainer, vFrom);
        Rect to = getRect(vContainer, vTo);
        final View view = animUnit.getView(vContainer, from, to);
        Paddings paddings = new Paddings(vContainer);
        Animator anim = animUnit.getAnim(paddings, view, from, to);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                vContainer.addView(view);
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
        anim.start();
    }
}
