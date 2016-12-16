package dev.xesam.android.fly;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by xe on 16-12-16.
 */

public class FlyAnim {
    private ViewGroup vContainer;
    private View vFrom;
    private View vTo;

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

    public void from(View from) {

    }

    public void to(View to) {

    }

    public void start() {

    }
}
