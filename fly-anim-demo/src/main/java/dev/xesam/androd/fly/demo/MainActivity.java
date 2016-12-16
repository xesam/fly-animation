package dev.xesam.androd.fly.demo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import dev.xesam.android.fly.FlyAnim;

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
                FlyAnim anim = new DemoFly();
                anim.container(vMain);
                anim.from(vFrom);
                anim.to(vTo);
                anim.start();
            }
        }, 1000);

    }
}
