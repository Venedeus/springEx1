package com.epam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Date;
import java.util.Map;

/**
 * Created by Evgeniy_Shvetsov on 2/1/2018.
 */
public class App {
	
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultLogger, Map<EventType,
            EventLogger>
            loggers) {
        this.client = client;
		
        this.defaultLogger = defaultLogger;
		
        this.loggers = loggers;
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans.xml");

        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
		
        event.setMsg("New event!");
        app.logEvent(EventType.INFO, event);

        event = (Event) ctx.getBean("event");
        event.setMsg("New event!");
		
        app.logEvent(EventType.ERROR, event);

        ctx.close();
    }

    private void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);

        if(logger == null){
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }
}
