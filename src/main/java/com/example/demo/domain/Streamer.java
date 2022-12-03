package com.example.demo.domain;

public class Streamer {
    String Ip;
    String Id;

    public Streamer(String ip, String id) {
        Ip = ip;
        Id = id;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
