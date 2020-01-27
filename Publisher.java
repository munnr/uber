package com.test.uber;

import java.util.*;

public class Publisher implements Runnable{

    public Publisher(String publisherId){
        this.publisherId = publisherId;
    }
    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String channelId) {
        this.publisherId = channelId;
    }

    public Map<String,Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(Map<String,Channel> channelList) {
        this.channelList = channelList;
    }

    private String publisherId;

    private Map<String,Channel> channelList = new HashMap();

    public void publish(String channelId, Content content){
        Channel channel = channelList.get(channelId);
        if(channel == null){
            channel = new Channel();
            channel.setChannelId(channelId);
        }
        channel.publish(publisherId,content);
    }

    @Override
    public void run() {
        for(int i=0; i<10;i++) {
            Content content = generateContent();
            publish("channel1", content);
        }
    }

    public Content generateContent() {
        Content content = new Content();
        content.setContentId("content1");
        MetaData metaData = new MetaData();
        metaData.setContentId("content1");
        metaData.setExpiryDate(new Date());
        content.setMetaData(metaData);
        return content;
    }
}
