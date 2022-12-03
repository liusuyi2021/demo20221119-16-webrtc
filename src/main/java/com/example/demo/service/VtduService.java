package com.example.demo.service;

import com.example.demo.domain.Streamer;
import com.example.demo.domain.Vtdu;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VtduService {
    static List<Vtdu> vtdus;
    static List<Streamer> v1;
    static List<Streamer> v2;
    static List<Streamer> v3;
    static List<Streamer> v4;

    static {
        vtdus = new ArrayList<>();
        v1 = new ArrayList<>();
        v2 = new ArrayList<>();
        v3 = new ArrayList<>();
        v4 = new ArrayList<>();
        vtdus.add(new Vtdu("192.168.1.7", 6, v1));
        vtdus.add(new Vtdu("192.168.1.8", 10, v2));
        vtdus.add(new Vtdu("192.168.1.9", 5, v3));
        vtdus.add(new Vtdu("192.168.1.10", 12, v4));
    }

    //负载均衡计算
    public String Lvs() {
        Map<Object, Integer> vtdusmap = new HashMap<>();
        for (Vtdu v : vtdus) {
            int max = v.getMaxChannel();
            int real = v.getStreamers().size();
            int lastCount = max - real;
            if (lastCount > 0) {
                vtdusmap.put(v, lastCount);
            }
        }
        //判断如果都没有空余通道则返回空，否则返回对应的服务器ip
        if (vtdusmap.size() == 0) {
            return "";
        } else {
            Vtdu vtdu = (Vtdu) getMin(vtdusmap);
            return vtdu.getIp();
        }
    }

    //开始预览传递预览号
    public int Save(String ip, String id) {
        List<Streamer> streamers;
        for (Vtdu v : vtdus) {
            if (v.getIp().equals(ip)) {
                streamers =v.getStreamers();
                streamers.add(new Streamer(ip,id));
                v.setStreamers(streamers);
                return streamers.size();
            }
        }
        return  0;
    }

    //通过map的value比较大小取出最大最小值对应的key
    private Object getMin(Map<Object, Integer> map) {
        List<Map.Entry<Object, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().intValue() - o2.getValue().intValue()));
        // Object min = list.get(0).getKey();
        Object max = list.get(list.size() - 1).getKey();
        return max;
    }
}
