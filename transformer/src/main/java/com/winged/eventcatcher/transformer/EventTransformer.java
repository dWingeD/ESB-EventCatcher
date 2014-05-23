package com.winged.eventcatcher.transformer;


import com.winged.eventcatcher.client.Event;
import org.apache.camel.component.file.GenericFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;


/**
 */
public class EventTransformer {

    private static final transient Logger logger = Logger.getLogger(EventTransformer.class.getName());
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMddYYYY");


    public Object transform(Object messageFile) {
        File file = ((GenericFile<File>) messageFile).getFile();

        String message = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            message = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transformToEvent(message);
    }

    private Event transformToEvent(String message) {
        Event result = new Event();

        String[] values = message.split("|");
        result.setDescription(values[1]);
        result.setEmail(values[2]);
        try {
            result.setDate(DATE_FORMAT.parse(values[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

}
