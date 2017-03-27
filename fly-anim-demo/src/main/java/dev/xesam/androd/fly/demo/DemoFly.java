package dev.xesam.androd.fly.demo;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import dev.xesam.android.fly.FlyAnim;

/**
 * Created by xe on 16-12-16.
 */

@Deprecated
public class DemoFly extends FlyAnim {

    @Override
    protected View createFly(Rect from) {
        ImageView a = new ImageView(vContainer.getContext());
        a.setBackgroundColor(Color.RED);
        a.setImageResource(R.drawable.ic_launcher);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
//        a.setX(from.left);
//        a.setY(from.top);
        return a;
    }
}
