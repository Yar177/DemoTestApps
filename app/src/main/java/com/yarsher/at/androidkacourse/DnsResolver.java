package com.yarsher.at.androidkacourse;

import android.util.Log;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DnsResolver implements Runnable{

    private String domain;
    private InetAddress inetAddr;

    private static final String TAG = "DnsResolver";

    public DnsResolver(String domain){
        this.domain = domain;
    }

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName(domain);
            set(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Log.e(TAG, "UnknownHostException", e);

        }
    }

    private void set(InetAddress address) {
        this.inetAddr = inetAddr;
    }

    public synchronized InetAddress get() {
        return inetAddr;
    }


}
