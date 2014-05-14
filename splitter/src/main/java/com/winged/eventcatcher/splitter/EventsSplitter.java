package com.winged.eventcatcher.splitter;

import org.apache.camel.component.file.GenericFile;

import java.io.File;
import java.util.logging.Logger;

/**
 */
public class EventsSplitter {

    private static final transient Logger logger = Logger.getLogger(EventsSplitter.class.getName());


    public void split(Object body) {
        logger.info("|| ===== Input file class: " + body.getClass());

        GenericFile<File> file = (GenericFile<File>) body;

        logger.info("|| ===== Input file: " + file.getAbsoluteFilePath());
    }

}
