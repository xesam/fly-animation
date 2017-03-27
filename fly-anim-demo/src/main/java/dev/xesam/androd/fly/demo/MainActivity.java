package dev.xesam.androd.fly.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import dev.xesam.android.fly.FlyPlayer;
import dev.xesam.android.fly.SimpleAnimUnit;

public class MainActivity extends AppCompatActivity {

    RelativeLayout vMain;
    View vFrom;
    View vTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vMain = (RelativeLayout) findViewById(R.id.activity_main);
        vFrom = findViewById(R.id.from);
        vTo = findViewById(R.id.to);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView target = new ImageView(MainActivity.this);
                target.setBackgroundColor(Color.RED);
                target.setImageResource(R.drawable.ic_launcher);
                new FlyPlayer()
                        .container(vMain)
                        .from(vFrom)
                        .to(vTo)
                        .play(new SimpleAnimUnit(target, 30000));
            }
        }, 500);

    }
}
