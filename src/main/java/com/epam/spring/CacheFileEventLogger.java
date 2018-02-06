package com.epam.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy_Shvetsov on 2/1/2018.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(int cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache(){
        for(Event event: cache){
            logEvent(event);
        }
    }

    private void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
