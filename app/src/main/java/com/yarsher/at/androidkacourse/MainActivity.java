package com.yarsher.at.androidkacourse;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvText);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            boolean ctOn = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();

            Log.i(TAG, "NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(): " + ctOn);


            textView.setText("NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(): " + ctOn);

        }


    }
}
