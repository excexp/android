package com.example.doh;

import static java.util.Arrays.asList;

import androidx.annotation.NonNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import okhttp3.Dns;

public class MyDns implements Dns {
    @NonNull
    @Override
    public List<InetAddress> lookup(@NonNull String s) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("49.233.245.5") ;
        return asList(address);
    }
}
