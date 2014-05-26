package com.winged.eventcatcher.notifier;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;


/**
 * Created by winged on 26/05/14.
 */
public class EventNotifier {
    private static final transient Logger logger = Logger.getLogger(EventNotifier.class.getName());
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMddYYYY");


    public void notify(Object message) {
        logger.info("// ---- Notification about message ---- //");
        logger.info(message.toString());
    }
}
