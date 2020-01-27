package com.test.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Channel {

    public List<Subsciber> getSubsciberList() {
        return subsciberList;
    }

    public void setSubsciberList(List<Subsciber> subsciberList) {
        this.subsciberList = subsciberList;
    }

    private List<Subsciber> subsciberList = new ArrayList<Subsciber>();

    public void addSubsciber(Subsciber subsciber){
        subsciberList.add(subsciber);
    }

    public void removeSubsciber(Subsciber subsciber){
        subsciberList.remove(subsciber);
    }
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Map<String, Map<String, Content>> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Map<String, Content>> dataMap) {
        this.dataMap = dataMap;
    }

    private String channelId;

    private Map<String, Map<String,Content>> dataMap = new HashMap<String, Map<String, Content>>();

    public void publish(String publisherId, Content content){
        Map<String, Content> data = null;
        if(dataMap.containsKey(publisherId)){
            data = dataMap.get(publisherId);
        } else {
            data = new HashMap<String, Content>();
        }
        data.put(content.getContentId(), content);
        dataMap.put(publisherId,data);
        notifySubscriber(publisherId, content.getMetaData());
    }

    private void notifySubscriber(String publisherId, MetaData metaData){
        subsciberList.forEach(subscriber->{
            subscriber.notifySubscriber(publisherId,metaData);
        });
    }

}
