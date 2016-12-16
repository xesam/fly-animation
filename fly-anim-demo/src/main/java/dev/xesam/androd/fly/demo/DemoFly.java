package dev.xesam.androd.fly.demo;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dev.xesam.android.fly.FlyAnim;

/**
 * Created by xe on 16-12-16.
 */

public class DemoFly extends FlyAnim {

    @Override
    protected View createFly(Rect from) {
        ImageView a = new ImageView(vContainer.getContext());
        a.setImageResource(R.mipmap.ic_launcher);
        a.setX(from.left);
        a.setY(from.top);
        return a;
    }
}
