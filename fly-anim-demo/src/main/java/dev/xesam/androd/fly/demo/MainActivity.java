package dev.xesam.androd.fly.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import dev.xesam.android.fly.FlyPlayer;
import dev.xesam.android.fly.SimpleFlyUnit;

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

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView target = new ImageView(MainActivity.this);
                target.setBackgroundColor(Color.RED);
                target.setImageResource(R.drawable.ic_launcher);
                new FlyPlayer()
                        .container(vMain)
                        .from(vFrom)
                        .to(vTo)
                        .play(new SimpleFlyUnit(target, 3_000));
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlyPlayer flyPlayer = new FlyPlayer()
                        .container(vMain)
                        .from(vTo)
                        .to(vFrom);
                for (int i = 0; i < 5; i++) {
                    ImageView target = new ImageView(MainActivity.this);
                    target.setBackgroundColor(Color.RED);
                    target.setImageResource(R.drawable.ic_launcher);
                    flyPlayer.play(new SimpleFlyUnit(target, 1_000 * i));
                }
            }
        });

    }
}
