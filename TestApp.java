package com.test.uber;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestApp {

    public static void main(String[] args) {
        Publisher publisher = new Publisher("publisher1");
        Subsciber subsciber = new Subsciber("subscriber1");
        Map<String,Channel> channelsMap = new HashMap<>();
        Channel channel = new Channel();
        channel.setChannelId("channel1");
        channelsMap.put("channel1",channel);
        subsciber.subscribeChannel("channel1",channelsMap);
        publisher.setChannelList(channelsMap);
        Thread thread = new Thread(publisher);
        thread.start();

    }
}
