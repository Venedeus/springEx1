package com.epam.spring;

import java.util.List;

/**
 * Created by Evgeniy_Shvetsov on 2/2/2018.
 */
public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> listOfEventLoggers;

    public CombinedEventLogger(List<EventLogger> listOfEventLoggers) {
        this.listOfEventLoggers = listOfEventLoggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : listOfEventLoggers) {
            logger.logEvent(event);
        }
    }
}
