package com.yarsher.at.androidkacourse;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.net.InetAddress;

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

       testDNS("www.google.com", 500000);
    }//end onCreate


    public boolean testDNS(String hostname, long timeOut){

        try {
        DnsResolver dnsResolver = new DnsResolver(hostname);
        Thread thread = new Thread(dnsResolver);
        thread.start();
        thread.join(timeOut);
        InetAddress inetAddress = dnsResolver.get();
        return inetAddress != null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(TAG, "testDNS: ", e);
            return false;
        }

    }



}
