package com.winged.eventcatcher.splitter;

import org.apache.camel.component.file.GenericFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 */
public class EventsSplitter {

    private static final transient Logger logger = Logger.getLogger(EventsSplitter.class.getName());


    public List<Object> split(Object body) {
        File file = ((GenericFile<File>) body).getFile();

        logger.info("|| ===== Input file for split: " + file.getName());

        List<Object> result = new ArrayList<Object>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            for(String line; (line = reader.readLine()) != null; ) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
