package com.epam.spring;

/**
 * Created by Evgeniy_Shvetsov on 2/1/2018.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
