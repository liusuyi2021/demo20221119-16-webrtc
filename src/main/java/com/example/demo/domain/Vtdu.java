package com.example.demo.domain;

import java.util.List;

public class Vtdu {
    String Ip;
    int MaxChannel;
    List<Streamer>streamers;

    public Vtdu(String ip, int maxChannel, List<Streamer> streamers) {
        Ip = ip;
        MaxChannel = maxChannel;
        this.streamers = streamers;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public int getMaxChannel() {
        return MaxChannel;
    }

    public void setMaxChannel(int maxChannel) {
        MaxChannel = maxChannel;
    }

    public List<Streamer> getStreamers() {
        return streamers;
    }

    public void setStreamers(List<Streamer> streamers) {
        this.streamers = streamers;
    }
}
