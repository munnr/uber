package com.test.uber;

import java.util.HashMap;
import java.util.Map;

public class Subsciber {

    private Map<String, MetaData> notifiedContent = new HashMap<>();

    private String subscriberId;

    private Map<String, Channel> channelMap = new HashMap<>();

    public Subsciber(String subscriberId){
        this.subscriberId = subscriberId;
    }

    public void notifySubscriber(String publisherId, MetaData metaData){
        notifiedContent.put(publisherId,metaData);
        System.out.println(" Publisher: "+ publisherId +" published the content "+ metaData.toString());
    }

    public void subscribeChannel(String channelId, Map<String, Channel> channelMap){
        Channel channel = channelMap.get(channelId);
        if(channel ==null){

        }
        channel.addSubsciber(this);
        this.channelMap.put(channelId,channel);
    }

    private void processData(String contentId){
        MetaData metaData = notifiedContent.get(contentId);
        String channelId = metaData.getChannelId();
        Channel channel = channelMap.get(channelId);

    }

}
