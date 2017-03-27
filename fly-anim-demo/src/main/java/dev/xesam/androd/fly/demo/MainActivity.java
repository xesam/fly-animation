package dev.xesam.androd.fly.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

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
                new DemoFly()
                        .container(vMain)
                        .from(vFrom)
                        .to(vTo)
                        .start();
            }
        }, 1000);

    }
}
